package com.test.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate a list of n Fibonacci numbers
 * author: vhblasco
 */
public class IterativeFibonacci implements FibCalculator{


    private static final double PHI = (1 + (Math.sqrt(5))) / 2;


    /**
     * Method to calculate the Fibonacci number in position n.
     * This only works until Fibonacci 47, then
     * we reach more than 2147483647 (Integer.MAX_VALUE)
     * and the method returns the maximum integer
     * (not the real fibonacci number)
     *
     * @param nth
     * @return
     */
    @Override
    public int calculate(int nth) {
        return Double.valueOf((Math.pow(PHI,nth) - Math.pow(1 - PHI, nth))
                               / Math.sqrt(5)).intValue();
    }


    /**
     * Method to calculate the list of first n Fibonacci numbers
     * @param fibNumber
     * @return
     */
    public List<Integer> listNFibonacci(int fibNumber) {

        List<Integer> list = new ArrayList<>();

        // The first Fibonacci is 0, {0}
        if (fibNumber == 1) list.add(0);
        // The second Fibonacci is 1, {1, 0}
        else if (fibNumber == 2) {list.add(0);list.add(1);}
        else {
            // Then we can define the Fibonacci in position n-2 as:
            // F(n-2) = F(n) - F(n-1)
            int initial = calculate(fibNumber -1);
            int prev = calculate(fibNumber - 2);

            list.add(initial);
            list.add(prev);

            Integer fibonacci;
            do {
                fibonacci = initial - prev;
                list.add(fibonacci);

                initial = prev;
                prev = fibonacci;

            } while (fibonacci > 0);
        }

        return list;
    }


    /**
     * Test it.
     * @param args
     */
    public static void main(String[] args) {
        IterativeFibonacci ib = new IterativeFibonacci();
        List<Integer> list = ib.listNFibonacci(21);

        System.out.println("Size:" + list.size());
        System.out.println(list);
    }
}


