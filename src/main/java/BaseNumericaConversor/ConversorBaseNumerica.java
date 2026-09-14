package BaseNumericaConversor;

public class ConversorBaseNumerica {
    public static void main(String[] args) {
        int numero = 220; // Número en base 10

        // Convertir a binario
        char[] binario = Integer.toBinaryString(numero).toCharArray();

        // Convertir a octal
        char[] octal = Integer.toOctalString(numero).toCharArray();

        // Convertir a hexadecimal
        char[] hexadecimal = Integer.toHexString(numero).toCharArray();

        // Mostrar resultados
        System.out.println("Número en base 10: " + numero);
        System.out.println("Binario (base 2): " + new String(binario));
        System.out.println("Octal (base 8): " + new String(octal));
        System.out.println("Hexadecimal (base 16): " + new String(hexadecimal).toUpperCase());
    }
}
