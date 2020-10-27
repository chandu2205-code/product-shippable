package com.javacode.util;

import sun.misc.ClassLoaderUtil;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Below class acts as utility to interact with underlying
 * file system to read,parse and return output as requested
 */
public class FileReader {

    /**
     * Below method reads and parses text file from specified path
     * Each line in file is expected to be in form of [integer,integer]
     * @param fileName name of the file which needs to be parsed
     * @return {@link Map} information in text file is mapped to {@link Map}
     * @throws Exception if file is not found or not available in expected format
     */
    public Map<Integer,Integer> readTextFile(Optional<String> fileName) throws Exception {
        Map<Integer,Integer> map = new HashMap<>();
        if (!fileName.isPresent()) throw new Exception("File name cannot be empty");
        URL resource = this.getClass().getClassLoader().getResource(fileName.get());
        if (null == resource) throw new IllegalArgumentException(String.format("File not found ! %s",fileName.get()));
        File file = new File(resource.toURI());
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] strArray = line.split(",");
            map.put(Integer.parseInt(strArray[0]),Integer.parseInt(strArray[1]));
        }
        return map;
    }
}
