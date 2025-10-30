package app.core.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    /** Acepta SOLO los valores listados (varargs). Ej: readMenuOptionAllowed(1,2) */
    public static int readMenuOptionAllowed(int... allowedValues) {
        if (allowedValues == null || allowedValues.length == 0)
            throw new IllegalArgumentException("Se requiere al menos un valor permitido.");
        // Normalizamos y mostramos ayuda:
        Set<Integer> allowed = Arrays.stream(allowedValues).boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        String legend = "> (" + allowed.stream().map(String::valueOf).collect(Collectors.joining(",")) + "): ";
        return readIntAllowed(legend, allowed);
    }

    public static int readMenuOptionAllowed(Set<Integer> allowedValues) {
        if (allowedValues == null || allowedValues.isEmpty())
            throw new IllegalArgumentException("Se requiere al menos un valor permitido.");
        String legend = "> (" + allowedValues.stream().map(String::valueOf).collect(Collectors.joining(",")) + "): ";
        return readIntAllowed(legend, allowedValues);
    }

    private static int readIntAllowed(String prompt, Set<Integer> allowed) {
        while (true) {
            int val = readIntSafe(prompt);
            if (allowed.contains(val)) return val;
            System.out.println("⚠ Opción inválida. Valores permitidos: " + allowed);
        }
    }

    /* ====== NUEVO: Índices 1-based (sin 0) para listas ====== */

    /** Para listas mostradas 1..N. Retorna índice 1..N (nunca 0). */
    public static int readIndex1Based(String prompt, int size) {
        if (size <= 0) throw new IllegalArgumentException("La lista está vacía.");
        return readIntInRange(prompt, 1, size);
    }

    /** Igual que arriba, pero imprime prompt estándar automáticamente. */
    public static int readIndex1Based(int size) {
        return readIndex1Based("> (1.." + size + "): ", size);
    }

    /** Opcional: retorna 0 para “volver”, o 1..N como índice válido. */
    public static int readIndex1BasedOrZero(int size) {
        if (size <= 0) throw new IllegalArgumentException("La lista está vacía.");
        return readIntInRange("> (0 para volver, 1.." + size + "): ", 0, size);
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