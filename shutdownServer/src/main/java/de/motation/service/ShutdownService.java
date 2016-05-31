package de.motation.service;

import de.motation.entity.Timer;
import de.motation.thread.CountdownThread;
import org.springframework.stereotype.Service;

/**
 * Created by motation on 31.05.16.
 */
@Service
public class ShutdownService {
    private CountdownThread countdown;

    public void startCountdown(Timer timer) {
        if (countdown == null) {
            CountdownThread countdownThread = new CountdownThread();
            this.countdown = countdownThread;
            this.countdown.setTimer(timer);
            this.countdown.start();
        }
    }

    public void cancelCountdown() {
        if (countdown == null) {
            return;
        }
        this.countdown.interrupt();
        this.countdown = null;
        System.out.println("thread will be interrupted!");
        System.out.println(countdown);
    }
}
