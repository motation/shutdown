package de.motation.controller;

import de.motation.entity.VideoFile;
import de.motation.service.FileService;
import de.motation.service.VlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by sparky on 05.06.2016.
 */

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private VlcService vlcService;

    @RequestMapping(value = "/file")
    public List<VideoFile> videoFileList() {
        return fileService.createFilesAsList();
    }

    @RequestMapping(value = "/file/play", method = RequestMethod.POST)
    public void playVideo(@RequestParam final String filename) throws IOException {
        List<VideoFile> videoFiles = fileService.createFilesAsList();
        VideoFile selectedVideoFile = null;
        for (VideoFile videoFile : videoFiles) {
            if (videoFile.getName().equals(filename)) {
                selectedVideoFile = videoFile;
                break;
            }
        }
        if (selectedVideoFile != null) {
            vlcService.play(selectedVideoFile);
        }
    }
}
