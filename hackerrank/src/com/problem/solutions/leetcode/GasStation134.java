package com.problem.solutions.leetcode;

//Problem: https://leetcode.com/problems/gas-station/
public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(findGasStation1(gas, cost));
        System.out.println(findGasStation2(gas, cost));
        System.out.println(findGasStation3(gas, cost));
    }

    private static int findGasStation1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int loc = i;
            int totalGas = gas[i];
            int j = 0;
            while (j < gas.length) {
                if (totalGas - cost[loc % cost.length] >= 0) {
                    totalGas = totalGas - cost[loc % cost.length] + gas[(loc + 1) % cost.length];
                    ++loc;
                    ++j;
                } else {
                    break;
                }
            }
            if (j == gas.length) {
                return i;
            }
        }
        return -1;
    }


    private static int findGasStation2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int loc = i;
            int totalGas = 0;
            int j = 0;
            while (j < gas.length) {
                totalGas += gas[loc % cost.length] - cost[loc % cost.length];
                if (totalGas < 0) {
                    break;
                }
                ++j;
                ++loc;

            }
            if (j == gas.length && totalGas>=0) {
                return i;
            }
        }
        return -1;
    }

    private static int findGasStation3(int[] gas, int[] cost) {
        int delta = 0;
        int total=0;
        int i = 0;
        int result =0;
        while (i < gas.length) {
            delta += gas[i] - cost[i];
            total+=gas[i] - cost[i];
            if (delta < 0) {
                delta = 0;
                result = i + 1;
            }
            ++i;
        }
        return total >= 0?result:-1;

    }
}
