package de.motation.thread;

import de.motation.entity.Timer;

/**
 * Created by motation on 31.05.16.
 */
public class CountdownThread extends Thread {

    private Timer timer;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            long start = timer.getStartTime();
            long shutdownTime = start + timer.getShutdownInSecs() * 1000;
            if (shutdownTime <= System.currentTimeMillis()) {
                shutdown();
                this.interrupt();
            }
        }
    }

    private void shutdown(){
        System.out.println("SHUTDOWN NOW!!!!");
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}