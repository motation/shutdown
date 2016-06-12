package de.motation.service;

import de.motation.config.service.PathVideoService;
import de.motation.entity.VideoFile;
import de.motation.util.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sparky on 05.06.2016.
 */
@Service
public class FileService {

    @Autowired
    private PathVideoService pathVideoService;

    public List<VideoFile> createFilesAsList() {
        List<VideoFile> videoFileList = new ArrayList<VideoFile>();

        for (File file : new File(pathVideoService.getDownloadsdir()).listFiles()) {
            List<VideoFile> videoFiles = createVideoFile(file);
            videoFileList.addAll(videoFiles);
        }
        return videoFileList;
    }

    private List<VideoFile> createVideoFile(File file) {
        VideoFile videoFile = null;
        List<VideoFile> videoFiles = new ArrayList<VideoFile>();
        if (file.isDirectory()) {
            for (File fileInDir : file.listFiles()) {
                if (fileInDir.isDirectory()) {
                    List<VideoFile> temp = createVideoFile(fileInDir);
                    if (temp != null) {
                        videoFiles.addAll(temp);
                    }
                } else {
                    String fileName = fileInDir.getName();
                    if (VideoType.isVideo(fileName)) {
                        videoFile = new VideoFile(fileInDir);
                        videoFiles.add(videoFile);
                    }
                }
            }
        } else {
            String fileName = file.getName();
            if (VideoType.isVideo(fileName)) {
                videoFile = new VideoFile(file);
                videoFiles.add(videoFile);
            }
        }
        return videoFiles;
    }
}
