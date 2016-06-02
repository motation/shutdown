package de.motation.thread;

import de.motation.entity.Timer;

import java.io.IOException;

/**
 * Created by motation on 31.05.16.
 */
public class CountdownThread extends Thread {

    public static final String SHUTDOWN_CMD = "shutdown -s -f -t 1";
    private Timer timer;

    @Override
    public void run() {
        long start = timer.getStartTime();
        long shutdownInMilliSecs = timer.getShutdownInSecs() * 1000;
        long shutdownTime = start + shutdownInMilliSecs;

        while (!this.isInterrupted()) {
            try {
                Thread.sleep(shutdownInMilliSecs);
            } catch (InterruptedException e) {
                interrupt();
            }
            if (!isInterrupted() && shutdownTime <= System.currentTimeMillis()) {
                shutdown();
                interrupt();
            }
        }
    }

    private void shutdown() {
        try {
            Runtime.getRuntime().exec(SHUTDOWN_CMD);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
