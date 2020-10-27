package com.javacode.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EnumerateRangesImplTest {

    @Test
    public void findMinimumRangesTest() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(94133,94133);
        map.put(94200,94299);
        map.put(94226,94399);

        EnumerateRangesImpl enumerateRanges = new EnumerateRangesImpl();

        Map<Integer,Integer> outputMap = enumerateRanges.findMinimumRanges(map);
        Assert.assertNotEquals(map.size(),outputMap.size());
        Assert.assertEquals(2l,outputMap.size());

    }
}
