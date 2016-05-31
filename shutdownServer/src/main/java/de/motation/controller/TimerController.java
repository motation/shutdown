package de.motation.controller;

import de.motation.dto.TimerDTO;
import de.motation.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by motation on 31.05.16.
 */
@RestController
public class TimerController {

    @Autowired
    private TimerService timerService;

    @RequestMapping(value = "/timer", method = RequestMethod.POST)
    public TimerDTO createTimer(@RequestParam final int shutdownInSeconds) {
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


}
