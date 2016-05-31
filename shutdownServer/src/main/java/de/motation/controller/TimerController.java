package de.motation.controller;

import de.motation.dto.TimerDTO;
import de.motation.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by motation on 31.05.16.
 */
@RestController
public class TimerController {

    @Autowired
    private TimerService timerService;

    @RequestMapping(value = "/timer", method = RequestMethod.POST)
    public TimerDTO createTimer(@RequestParam final long shutdownInSeconds) {
        return timerService.createTimer(shutdownInSeconds);
    }

    @RequestMapping(value = "/timer", method = RequestMethod.GET)
    public TimerDTO timer() {
        return timerService.getTimer();
    }

    @RequestMapping(value = "/timer", method = RequestMethod.DELETE)
    public TimerDTO removeTimer() {
        return timerService.removeTimer();
    }

    @RequestMapping(value = "/timer/cancel", method = RequestMethod.GET)
    public TimerDTO shutdownCancel() {
        return this.timerService.removeTimer();
    }


}
