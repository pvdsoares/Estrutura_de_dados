import java.util.Arrays;
/*Crie um algoritmo/fluxograma/programa que preencha um array com os números
 em ordem inversa.*/

public class Questao3{

    public static void main(String[] args){
         int[] array = {10, 20, 30, 40};
         int[] arrayinverso = new int[array.length];

        for(int i = array.length-1, j=0; i>=0; i--, j++){
           arrayinverso[j] = array[i];
          }  

          System.out.println("Array inverso\n" + Arrays.toString(arrayinverso));
        }

    }
