package com.problem.solutions.hackerrank;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Stack;

class TestClassPhilosopher {
    
    public static void main(String args[] ) throws Exception {
        InputReader sc = new InputReader(System.in);
        int N = sc.readInt();
        Queue<Integer> harryBag = new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            harryBag.offer(sc.readInt());
        }
        int Q = sc.readInt();
        int X = sc.readInt();
        Stack<Integer> monksBag = new Stack<>();
 
        for(int i=0;i<Q;i++) {
            if(sc.next().equals("Harry")) {
                if(harryBag.isEmpty()) {
                    System.out.println("-1");
                    return;
                }else{
                    int coinValue = harryBag.poll();
                    monksBag.push(coinValue);
                    X -= coinValue;
                }
                if(X == 0) {
                    System.out.println(monksBag.size());
                    return;
                }
            }else{
                X += monksBag.pop();
            }
        }
        System.out.println("-1");
    }
    
    static class InputReader {
 
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
            this.stream = stream;
    }
 
    public int read() {
            if (numChars == -1)
                    throw new InputMismatchException();
            if (curChar >= numChars) {
                    curChar = 0;
                    try {	
                            numChars = stream.read(buf);
                    } catch (IOException e) {
                            throw new InputMismatchException();
                    }
                    if (numChars <= 0)
                            return -1;
            }
            return buf[curChar++];
    }
 
    public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                    c = read();
            int sgn = 1;
            if (c == '-') {
                    sgn = -1;
                    c = read();
            }
            int res = 0;
            do {
                    if (c < '0' || c > '9')
                            throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
    }
    
    
 
    public String readString() {
            int c = read();
            while (isSpaceChar(c))
                    c = read();
            StringBuilder res = new StringBuilder();
            do {
                    res.appendCodePoint(c);
                    c = read();
            } while (!isSpaceChar(c));
            return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
            if (filter != null)
                    return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
            return readString();
    }
 
    public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
    }
}
 
}