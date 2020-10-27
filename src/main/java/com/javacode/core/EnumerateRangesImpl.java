package com.javacode.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Below class is one of the implementation for {@link EnumerateRanges}
 */
public class EnumerateRangesImpl implements EnumerateRanges{

    @Override
    public Map<Integer, Integer> findMinimumRanges(Map<Integer, Integer> inputMap) {

        TreeMap<Integer,Integer> sortedRanges = new TreeMap<>();
        sortedRanges.putAll(inputMap);
        System.out.println(sortedRanges);
        return removeOverlappingRanges(sortedRanges);
    }

    /**
     * Below class returns minimized ranges by removing overlapping ranges
     * @param sortedMap
     * @return {@link Map} below class returns minimized ranges
     */
    private Map<Integer,Integer> removeOverlappingRanges(Map<Integer, Integer> sortedMap) {
        Map<Integer, Integer> minimizedRange = new HashMap<>();

        Map.Entry<Integer,Integer> previousEntry = null;
        for (Map.Entry<Integer,Integer> entry : sortedMap.entrySet()) {
                if (previousEntry == null) {
                    previousEntry = entry;
                    minimizedRange.put(entry.getKey(), entry.getValue());
                    continue;
                }

                if (entry.getKey() > previousEntry.getKey() && entry.getKey() < previousEntry.getValue()) {
                    minimizedRange.put(previousEntry.getKey(), entry.getValue());
                } else if (entry.getKey() > previousEntry.getValue()) {
                    minimizedRange.put(entry.getKey(), entry.getValue());
                } else if (entry.getKey() == previousEntry.getValue()) {
                    minimizedRange.put(previousEntry.getKey(), entry.getValue());
                } else {
                    minimizedRange.put(entry.getKey(), entry.getValue());
                }
                previousEntry = entry;
        }
        return minimizedRange;
    }
}
