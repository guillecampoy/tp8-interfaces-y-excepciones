package app.core.utils;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleIO {
    private static final Scanner SC = new Scanner(System.in);

    /* ====== Lecturas básicas ====== */

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return SC.nextLine();
    }

    public static void println(String msg) { System.out.println(msg); }

    public static void hr() { System.out.println("-".repeat(40)); }

    public static void pause() {
        System.out.print("Presioná ENTER para continuar...");
        SC.nextLine();
    }

    /* ====== Enteros ====== */

    /** Lee un entero con retry infinito hasta que sea válido. */
    public static int readIntSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Valor inválido. Ingresá un número entero.");
            }
        }
    }

    /** Lee un entero en [min..max], con retry. */
    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int val = readIntSafe(prompt);
            if (val < min || val > max) {
                System.out.printf("⚠ Debe estar entre %d y %d.%n", min, max);
                continue;
            }
            return val;
        }
    }

    /* ====== Doubles / BigDecimal ====== */

    public static double readDoubleSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Valor inválido. Ingresá un número (ej: 123.45).");
            }
        }
    }

    public static BigDecimal readBigDecimalSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim().replace(',', '.');
            try {
                return new BigDecimal(s);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Valor inválido. Ingresá un número (ej: 123.45).");
            }
        }
    }

    /* ====== Helpers de menú ====== */

    /**
     * Muestra opciones numeradas (1..N) y retorna la selección válida.
     * Si allowExit es true, permite 0 para “volver/salir”.
     */
    public static int readMenuOption(int itemsCount, boolean allowExit) {
        int min = allowExit ? 0 : 1;
        int max = itemsCount;
        String legend = allowExit ? String.format("> (0..%d): ", max) : String.format("> (1..%d): ", max);
        return readIntInRange(legend, min, max);
    }

    /* ====== Sí/No ====== */

    public static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " [s/n]: ");
            String s = SC.nextLine().trim().toLowerCase();
            if (s.equals("s") || s.equals("si") || s.equals("sí")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("⚠ Respuesta inválida. Usá 's' o 'n'.");
        }
    }

    /* ====== Genérico con validador ====== */

    public static String readLineMatching(String prompt, Predicate<String> validator, String errorMsg) {
        while (true) {
            String s = readLine(prompt).trim();
            if (validator == null || validator.test(s)) return s;
            System.out.println(errorMsg != null ? errorMsg : "⚠ Entrada inválida.");
        }
    }
}