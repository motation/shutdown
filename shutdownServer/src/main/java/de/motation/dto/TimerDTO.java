package de.motation.dto;

import de.motation.entity.Timer;

/**
 * Created by motation on 31.05.16.
 */
public class TimerDTO {
    private Timer timer;

    private TimerDTO() {

    }

    public Timer getTimer() {
        return timer;
    }

    public static TimerDTOBuilder builder() {
        return new TimerDTOBuilder();
    }

    public static class TimerDTOBuilder {
        private TimerDTO timerDTO;

        private TimerDTOBuilder() {
            this.timerDTO = new TimerDTO();
        }

        public TimerDTOBuilder withTimer(Timer timer) {
            this.timerDTO.timer = timer;
            return this;
        }

        public TimerDTO build() {
            return this.timerDTO;
        }
    }
}
