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
        String webControl = "-I http";
        String remoteControl = "--rc-host=localhost:4444";
        String webAdr = "--http-host=localhost";
        String webPort = "--http-port=81";
        String webPass = "--http-password=123";
        String command = quotationMark + pathVideoService.getVlcdir() + quotationMark + whitespace +
                webControl + whitespace + webAdr + whitespace + webAdr + whitespace +
                webPort + whitespace + webPass + whitespace + quotationMark +
                selectedVideoFile.getAbsPathVideo() + quotationMark;
        Process proc = Runtime.getRuntime().exec(command);
        this.activeProc = proc;
    }
}
