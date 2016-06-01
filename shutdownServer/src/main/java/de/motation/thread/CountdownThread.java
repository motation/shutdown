package de.motation.thread;

import de.motation.entity.Timer;

import java.io.IOException;

/**
 * Created by motation on 31.05.16.
 */
public class CountdownThread extends Thread {

    private Timer timer;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            long start = timer.getStartTime();
			long shutdownInMilliSecs = timer.getShutdownInSecs() * 1000;
            long shutdownTime = start + shutdownInMilliSecs;
			try{
				Thread.sleep(shutdownInMilliSecs);
			} catch(Exception e){
				System.out.println("Problem while Thread sleep.");
			}
            if (shutdownTime <= System.currentTimeMillis()) {
                shutdown();
                this.interrupt();
            }
        }
    }

    private void shutdown() {
        System.out.println("SHUTDOWN NOW!!!!");
        String shutdownCmd = "shutdown -s -f -t 1";
        try {
            Process child = Runtime.getRuntime().exec(shutdownCmd);
        } catch (IOException e) {
            System.out.println("Shutdown failed");
        }
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
