package de.motation.service;

import de.motation.config.service.PathVideoService;
import de.motation.entity.VideoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by sparky on 12.06.2016.
 */
@Service
public class VlcService {
    private Process activeProc;

    @Autowired
    private PathVideoService pathVideoService;

    public void play(VideoFile selectedVideoFile) throws IOException {
        if (activeProc != null) {
            activeProc.destroy();
        }

        String quotationMark = "\"";
        String whitespace = " ";
        String fullscreen = "--fullscreen";
        String command = quotationMark + pathVideoService.getVlcdir() + quotationMark + whitespace +
                fullscreen + whitespace + quotationMark + selectedVideoFile.getAbsPathVideo() + quotationMark;
        Process proc = Runtime.getRuntime().exec(command);
        this.activeProc = proc;
    }
}
