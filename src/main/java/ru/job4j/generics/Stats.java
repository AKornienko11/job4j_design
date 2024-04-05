package ru.job4j.generics;

public class Stats<T extends Number> {
    T[] nums;

    Stats(T[] t) {
        nums = t;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> st) {
        if (average() == st.average()) {
            return true;
        }
        return false;

    }





}
