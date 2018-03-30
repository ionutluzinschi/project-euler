package com.myproject.euler.exercises.exercise38;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PandigitalMultiples {
    private static Logger LOGGER = LoggerFactory.getLogger(PandigitalMultiples.class);
    private long largest = 123456789;
    private Map<String, Long> map = new HashMap<>();

    public static boolean isUnique(long x) {
        Set<Long> digits = new HashSet<>();
        while (x > 0) {
            if (x % 10 == 0 || digits.contains(x % 10)) {
                return false;
            } else {
                digits.add(x % 10);
                x = x / 10;
            }
        }
        return true;
    }

    public long calculateLargestPandigital() {
        long max = 999;
        long result = 0;
        boolean done = false;

        for (long i = 2; i < 999999999 / 2; i++) {
            String name = "";
            done = false;
            for (int j = 1; j < 9 && done == false; j++) {
                long c = i * j;
                if (isUnique(c)) {
                    name = name + c;
                    if (!isUnique(Long.parseLong(name))) {
                        done = true;
                        break;
                    } else {
                        if (Long.parseLong(name) > largest && Long.parseLong(name) <= 987654321) {
                            largest = Long.parseLong(name);
                            LOGGER.info("new Largest is" + largest);
                        }
                    }
                } else {
                    done = true;
                }
            }
        }
        LOGGER.info("max pandigital is " + largest);
        return largest;
    }

    public long getLargest() {
        return largest;
    }

    public void setLargest(long largest) {
        this.largest = largest;
    }

    public Map<String, Long> getMap() {
        return map;
    }

    public void setMap(Map<String, Long> map) {
        this.map = map;
    }
}
