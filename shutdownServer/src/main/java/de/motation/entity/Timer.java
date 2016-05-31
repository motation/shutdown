package de.motation.entity;

/**
 * Created by motation on 31.05.16.
 */
public class Timer {
    private long startTime;
    private long shutdownInSecs;
    private Timer timer;


    private Timer() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getShutdownInSecs() {
        return shutdownInSecs;
    }

    public static TimerBuilder builder() {
        return new TimerBuilder();
    }

    public static class TimerBuilder {

        private Timer timer;

        private TimerBuilder() {
            this.timer = new Timer();
        }

        public TimerBuilder withShudownInSeconds(long seconds) {
            this.timer.shutdownInSecs = seconds;
            return this;
        }

        public Timer build() {
            return this.timer;
        }


    }
}
