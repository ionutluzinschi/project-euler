package com.myproject.euler.exercises.exercise41;

import com.myproject.euler.exercises.exercise38.PandigitalMultiples;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PandigitalPrime {
    private static Logger LOGGER = LoggerFactory.getLogger(PandigitalPrime.class);
    private Long largest = 1L;

    public void calculateLargestPandigitalPrime() {
        boolean primeFound = false;
        int x = 87_654_319;
        while (!primeFound) {
            if (PandigitalMultiples.isUnique(x) && isPrime(x)) {
                String name = Long.toString(x);
                if (largestDig(x) <= name.length()) {
                    primeFound = true;
                    LOGGER.info("largest = " + x);
                }
            }
            x--;
        }
    }

    public int largestDig(int x) {
        int largest = 1;
        while (x > 0) {
            if (x % 10 > largest) {
                largest = x % 10;
            }
            x /= 10;
        }
        return largest;
    }


    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
