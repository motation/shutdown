package de.motation.service;

import de.motation.dto.TimerDTO;
import de.motation.entity.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public TimerDTO createTimer(int shutdownInSeconds) {
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
}
