import java.util.Random;

public class RecorridoArreglo {
    public static void main (String[] args){

        int [] numeros = new int [10];
        Random rd = new Random();

        for (int i=0; i< numeros.length; i++ ){
            numeros[i] = rd.nextInt(100) + 1;
        }
        // for clasico
        System.out.println("Recorrido con el 'for clasico':");

        for (int i=0; i < numeros.length; i ++){
            System.out.println("posicion" + i + ":" + numeros[i]);
        }

        //for-each
        System.out.println("Recorrido con el 'for-each':");

        for(int numero : numeros) {
            System.out.println(numero);
        }
    }
}
