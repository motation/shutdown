package de.motation.service;

import de.motation.dto.TimerDTO;
import de.motation.entity.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by motation on 31.05.16.
 */
@Service
public class TimerService {

    @Autowired
    private ShutdownService shutdownService;

    private Timer timer;

    public TimerDTO getTimer() {
        TimerDTO timerDTO = TimerDTO.builder().withTimer(timer).build();
        return timerDTO;
    }

    public TimerDTO createTimer(long shutdownInSeconds) {
        this.timer = Timer.builder()
                .withShudownInSeconds(shutdownInSeconds)
                .build();
        shutdownService.startCountdown(timer);
        return getTimer();
    }

    public TimerDTO removeTimer() {
        this.timer = null;
        shutdownService.cancelCountdown();
        return getTimer();
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://192.168.178.37:8080/timer");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            String line = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
