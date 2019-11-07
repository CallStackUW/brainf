package com.company;

import java.util.Stack;

public class Main {

    private static final int max = 4096;
    public static void main(String[] args) {

    }

    private void interpret(String code) {
        Stack<Integer> stack = new Stack<>();
        int pointer = max/2;
        Byte[] tape = new Byte[max];
        for (int pc = 0; pc < code.length(); pc++) {
            char cmd = code.charAt(pc);
            if (cmd == '+') {
                tape[pointer]++;
            } else if (cmd == '-') {
                tape[pointer]--;
            } else if (cmd == '<') {
                pointer--;
            } else if (cmd == '>') {
                pointer++;
            }
        }
    }
}
