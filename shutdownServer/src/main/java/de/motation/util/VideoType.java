package de.motation.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sparky on 05.06.2016.
 */
public final class VideoType {
    private static Map<String, Boolean> videoTypeMap = new HashMap<String, Boolean>();

    static {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("mkv", true);
        map.put("avi", true);
        videoTypeMap = Collections.unmodifiableMap(map);
    }

    public static boolean isVideo(String filename) {
        Boolean isVideo = false;
        String[] splitter = filename.split("\\.");
        String ending = splitter[splitter.length - 1];
        if (ending != null) {
            isVideo = videoTypeMap.get(ending);
        }
        return isVideo != null && isVideo;
    }
}
