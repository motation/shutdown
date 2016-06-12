package de.motation.config.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by sparky on 12.06.2016.
 */
@Component
@ConfigurationProperties(prefix="videoservice")
public class PathVideoService {

    private String downloadsdir;
    private String vlcdir;

    public String getDownloadsdir() {
        return downloadsdir;
    }

    public String getVlcdir() {
        return vlcdir;
    }

    public void setDownloadsdir(String downloadsdir) {
        this.downloadsdir = downloadsdir;
    }

    public void setVlcdir(String vlcdir) {
        this.vlcdir = vlcdir;
    }
}
