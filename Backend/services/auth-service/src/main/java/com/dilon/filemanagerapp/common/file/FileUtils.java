package com.dilon.filemanagerapp.common.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileUtils {
    public static byte[] readFileFromLocation(String profilePictureUrl) {
        if (StringUtils.isNotBlank(profilePictureUrl)){
            return null;
        }
        try{
            Path filePath = new File(profilePictureUrl).toPath();
            return Files.readAllBytes(filePath);
        }catch (IOException e){
            log.warn("Error reading file from location: {}", profilePictureUrl, e);
        }
        return null;
    }
}
