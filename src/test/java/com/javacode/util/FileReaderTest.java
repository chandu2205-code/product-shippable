package com.javacode.util;

import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {

    @Test
    public void readTextFileTest() throws Exception {
        Optional<String> fileName = Optional.ofNullable("test.txt");
        FileReader fileReader = new FileReader();
        Map<Integer,Integer> map = fileReader.readTextFile(fileName);
        Assert.assertNotNull(map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readTextFileTest_Exception() throws Exception {
        Optional<String> fileName = Optional.ofNullable("sample.txt");
        FileReader fileReader = new FileReader();
        fileReader.readTextFile(fileName);
    }
}
