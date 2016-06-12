package de.motation.entity;

import java.io.File;

/**
 * Created by sparky on 05.06.2016.
 */
public class VideoFile {
    private String absPathVideo;
    private String name;

    public VideoFile(File file) {
        absPathVideo = file.getAbsolutePath();
        name = file.getName();
    }

    public String getAbsPathVideo() {
        return absPathVideo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VideoFile{" +
                "name='" + name + '\'' +
                '}';
    }
}
