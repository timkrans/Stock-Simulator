package com.example.market.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxWhiskerStats {

    public double min;
    public double q1;
    public double median;
    public double q3;
    public double max;

    public static BoxWhiskerStats from(List<Double> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("No data available");
        }
        List<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        BoxWhiskerStats stats = new BoxWhiskerStats();
        stats.min = sorted.get(0);
        stats.max = sorted.get(sorted.size() - 1);
        stats.q1 = percentile(sorted, 25);
        stats.median = percentile(sorted, 50);
        stats.q3 = percentile(sorted, 75);

        return stats;
    }

    private static double percentile(List<Double> sorted, int p) {
        int index = (int) Math.ceil(p / 100.0 * sorted.size()) - 1;
        return sorted.get(Math.max(index, 0));
    }
}
