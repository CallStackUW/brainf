package com.company;

import java.util.Stack;
import java.util.Scanner;

public class Main {

    private static final int max = 4096;
    private static final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s = input.next();
        interpret(s);
    }

    private static void interpret(String code) {
        Stack<Integer> stack = new Stack<>();
        int pointer = max/2;
        byte[] tape = new byte[max];
        int numBrackets = 0;
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
            } else if (cmd == ',') {  
                tape[pointer] = input.nextByte();
            } else if (cmd == '.') {
                System.out.print((char)tape[pointer]);
            }   
        }
    }
}
