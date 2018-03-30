package com.myproject.euler.exercises.exercise39;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class IntegerRightTriangle {
    private static Logger LOGGER = LoggerFactory.getLogger(IntegerRightTriangle.class);
    private Map<Double, Integer> map = new HashMap<>();

    public void calcMax() {
        for (int i = 1; i < 500; i++) {
            for (int j = 1; j < 500; j++) {
                double x = calcPerim(i, j);
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }
        int max = 0;
        for (double y : map.keySet()) {
            if (map.get(y) > max) {
                max = map.get(y);
                LOGGER.info("y " + y + " max " + max);
            }
        }
        LOGGER.info("max " + max);
    }

    public double calcPerim(int a, int b) {
        return a + b + Math.sqrt(a * a + b * b);
    }
}
