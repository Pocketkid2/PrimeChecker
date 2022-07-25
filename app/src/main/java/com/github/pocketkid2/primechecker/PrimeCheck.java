package com.github.pocketkid2.primechecker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class PrimeCheck {

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;   // Numbers less than two are not prime
        }

        int max = (int) Math.sqrt(number);
        boolean prime = true;   // Assume prime unless we can prove false below

        for (int i = 2; i <= max; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }

    public static List<Integer> getFactorization(int number) {
        List<Integer> factorization = new ArrayList<>();

        int stop = number / 2;

        int factor = 2;
        while (factor <= stop) {
            while (number % factor == 0) {
                number /= factor;
                factorization.add(factor);
            }
            factor++;
        }

        return factorization;
    }
}
