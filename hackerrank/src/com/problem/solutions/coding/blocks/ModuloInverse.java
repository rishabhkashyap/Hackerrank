package com.problem.solutions.coding.blocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuloInverse {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(bufferedReader.readLine());
        long m = 1000000007;
        Equation equation = getModuloInverse(num, m);
        System.out.println((equation.x+m)%m);
    }

    private static Equation getModuloInverse(long num, long m) {
        Equation equation = new Equation();
        performExtendedEuclidMethod(num, m, equation);
        return equation;
    }

    private static void performExtendedEuclidMethod(long num, long m, Equation equation) {
        if (m == 0) {
            equation.x = 1;
            equation.y = 0;

        } else {
            performExtendedEuclidMethod(m,num%m, equation);
            long tempX = equation.y;
            long tempY = equation.x - (num / m) * equation.y;
            equation.x = tempX;
            equation.y = tempY;

        }
    }

    private static class Equation {
        private long x;
        private long y;
    }


}
