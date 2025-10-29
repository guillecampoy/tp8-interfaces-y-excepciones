package app.core.utils;

import java.util.Scanner;
public class ConsoleIO {
    private static final Scanner SC = new Scanner(System.in);
    public static String readLine(String prompt){ System.out.print(prompt); return SC.nextLine(); }
    public static int readInt(String prompt){ return Integer.parseInt(readLine(prompt)); }
    public static void hr(){ System.out.println("-".repeat(40)); }
}
