package features;

import core.SubMenu;

public class ExceptionCases extends SubMenu {

    public ExceptionCases(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {

    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        return false;
    }

    /*
 Parte 2: Ejercicios sobre Excepciones
1. División segura
○ Solicitar dos números y dividirlos. Manejar ArithmeticException si el
divisor es cero.
2. Conversión de cadena a número
○ Leer texto del usuario e intentar convertirlo a int. Manejar
NumberFormatException si no es válido.
3. Lectura de archivo
○ Leer un archivo de texto y mostrarlo. Manejar FileNotFoundException si
el archivo no existe.
4. Excepción personalizada
○ Crear EdadInvalidaException. Lanzarla si la edad es menor a 0 o mayor
a 120. Capturarla y mostrar mensaje.
5. Uso de try-with-resources
○ Leer un archivo con BufferedReader usando try-with-resources.
Manejar IOException correctamente.
     */
}
