/*Crie um algoritmo/fluxograma/programa que preencha um array com os quadrados dos números de 1 a N, 
onde N é um valor informado pelo usuário. */
import java.util.Scanner;

public class Questao2{

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("insíra um número: ");
        int n = scanner.nextInt();

        double[] array = new double[n];

        for(int i =0; i< array.length; i++){
            array[i]= Math.pow(i+1,2);
            System.out.println("o quadrado de " + (i+1) + " é " + array[i]);
        }

        scanner.close();
    }
} 