import java.util.Stack;
import java.util.Scanner;

public class Main {

    private static final int max = 4096 << 5;
    private static final Scanner input = new Scanner(System.in);

    static int pointer = max / 2;
    static byte[] tape = new byte[max];
    
    public static void main(String[] args) {
        String s = input.next();
        interpret(s);
    }

    private static void interpret(String code) {
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
                System.out.print((char) tape[pointer]);
            } else if (cmd == '[') {
                int startBracket = pc;
                int endBracket = 0;
                int bracketCounter = 0;

                // find endBracket
                for (int i = pc; i < code.length(); i++) {
                    if (code.charAt(i) == '[') {
                        bracketCounter++;
                    } else if (code.charAt(i) == ']') {
                        bracketCounter--;
                        if (bracketCounter == 0) {
                            endBracket = i;
                            break;
                        }
                    }
                }

                // do the looping
                while (tape[pointer] != 0) {
                    interpret(code.substring(startBracket + 1, endBracket));
                }

                // move to end
                pc = endBracket; // NOTE we just removed the + 1 from here
            }
        }
    }
}
