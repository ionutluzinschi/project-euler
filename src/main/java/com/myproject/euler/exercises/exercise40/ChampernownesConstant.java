package com.myproject.euler.exercises.exercise40;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class ChampernownesConstant {
    private static Logger LOGGER = LoggerFactory.getLogger(ChampernownesConstant.class);
    private Stack<Long> stack = new Stack<>();

    public void calcConstant() {
        long sum = 1;
        long digit = 0;
        long x = 1;
        for (long i = 1; i < 1000000; i++) {
            long temp = i;
            while (temp > 0) {
                x = temp % 10;
                temp /= 10;
                stack.add(x);
            }
            while (!stack.empty()) {
                x = stack.pop();
                digit++;
                if (digit == 1 || digit == 10 || digit == 100 || digit == 1000 || digit == 10000 || digit == 100000 || digit == 1000000) {
                    sum = sum * x;
                }
            }
        }
        LOGGER.info("prod = " + sum);

    }
}
