package com.myproject.euler.exercises.exercise43;

import com.google.common.base.Stopwatch;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class SubstringDivisibility {
    private static final long[] primes = new long[]{2L, 3L, 5L, 7L, 11L, 13L, 17L};
    private long sum = 0;
    private Set<Long> set = new ConcurrentSkipListSet<>();

    public static boolean isDivisibleByPrimes(long x) {
        String name = Long.toString(x);
        name = name.substring(1);
        for (int i = 0; i < 7; i++) {
            long temp = Long.parseLong(name.substring(i, i + 3));
            if (temp % primes[i] != 0) {
                return false;
            }
        }
        System.out.println(x);
        return true;
    }

    public void calculateSum() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        permutingArray(java.util.Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), 0);
        long sum = set.stream().mapToLong(nr -> nr).filter(SubstringDivisibility::isDivisibleByPrimes).sum();
        System.out.println(stopwatch.elapsed());
        System.out.println("sume = " + sum);
    }

    public long getLong(List<Integer> list, int a, int b) {
        long x = 0;
        for (int i = a; i < a + b; i++) {
            x = x * 10 + list.get(i);
        }
        return x;
    }

    public boolean isDivisible(List<Integer> arrayList, int element) {
        if (getLong(arrayList, 1, 3) % 2 == 0) {
            if (element >= 4) {
                if (getLong(arrayList, 2, 3) % 3 == 0) {
                    if (element >= 5) {
                        if (getLong(arrayList, 3, 3) % 5 == 0) {
                            if (element >= 6) {
                                if (getLong(arrayList, 4, 3) % 7 == 0) {
                                    if (element >= 7) {
                                        if (getLong(arrayList, 5, 3) % 11 == 0) {
                                            if (element >= 8) {
                                                if (getLong(arrayList, 6, 3) % 13 == 0) {
                                                    if (element >= 9) {
                                                        if (getLong(arrayList, 7, 3) % 17 == 0) {
                                                            set.add(getLong(arrayList, 0, 10));
                                                            return true;
                                                        }
                                                    } else {
                                                        return true;
                                                    }
                                                }
                                            } else {
                                                return true;
                                            }
                                        }
                                    } else {
                                        return true;
                                    }
                                }
                            } else {
                                return true;
                            }
                        }
                    } else {
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public void permutingArray(java.util.List<Integer> arrayList, int element) {
        for (int i = element; i < arrayList.size(); i++) {
            java.util.Collections.swap(arrayList, i, element);
            if (arrayList.get(0) != 0) {
                permutingArray(arrayList, element + 1);
                if (element >= 3) {
                    isDivisible(arrayList, element);
                }
            }
            java.util.Collections.swap(arrayList, i, element);
        }
    }
}
