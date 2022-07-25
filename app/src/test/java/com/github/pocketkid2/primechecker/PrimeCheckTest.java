package com.github.pocketkid2.primechecker;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class PrimeCheckTest {

    private void print_factorization(int number) {
        List<String> factors = PrimeCheck.getFactorization(number).stream().map(i -> i.toString()).collect(Collectors.toList());
        String factorization = "";
        if (factors.size() == 0) {
            factorization = String.format("PRIME [1, %d]", number);
        } else {
            factorization = String.join(", ", factors);
        }
        System.out.println(String.format("Factorization (%d): %s", number, factorization));
    }

    @Test
    public void check_factorizations() {
        for (int i = 2; i < 50; i++) {
            print_factorization(i);
        }
    }
}
