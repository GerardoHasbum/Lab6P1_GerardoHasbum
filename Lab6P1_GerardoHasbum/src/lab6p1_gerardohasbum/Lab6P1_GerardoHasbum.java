/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_gerardohasbum;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ghasb
 */
public class Lab6P1_GerardoHasbum {

    static Scanner var = new Scanner(System.in);
    static Random ran = new Random();

    //Metodo Print
    public static void printChar(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 'a') {
                System.out.print("[" + array[i] + "] ");//Formato de impresion de array

            }
        }
        System.out.println();//Saltar a la siguiente linea
    }

    public static void printInt(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != (-1)) {
                System.out.print("[" + array[i] + "] ");//Formato de impresion de array

            }
        }
        System.out.println();//Saltar a la siguiente linea
    }

    //Metodos Conjuntos
    public static char[] setAleatorio(int size) {
        char[] temporal = new char[size];//Llamado de la variable temporal
        for (int i = 0; i < size; i++) {
            temporal[i] = (char) (65 + ran.nextInt(9));//Asignacion alazar de la posicion del array temporal
        }
        return temporal;//Retorno de la variable temporal
    }

    public static char[] interseccion(char[] array1, char[] array2) {
        char[] temporal = new char[array1.length + array2.length];
        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = 'a';
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array2[j] == array1[i]) {
                    temporal[i] = array1[i];
                    break;
                }
            }
        }
        return temporal;
    }

    public static char[] diferencia(char[] array1, char[] array2) {
        int cont = 0;
        char[] temporal = new char[array1.length+array2.length];
        for (int i = 0; i < array1.length; i++) {
            temporal[i]=array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            temporal[i+array1.length]=array2[i];
        }
                    char[] del = interseccion(array1,array2);

        for (int i = 0; i < temporal.length; i++) {
            for (int j = 0; j < del.length; j++) {
                if (temporal[i]==del[j]) {
                    temporal[i]='a';
                }
            }
        }
        return temporal;
    }

    //Metodos ¿Cuántos primos tienes?
    public static int[] getRandArray(int size, int max, int min) {
        int[] temporal = new int[size];
        for (int i = 0; i < size; i++) {
            temporal[i] = ran.nextInt((max - min) + 1) + min;
        }
        return temporal;
    }

    public static boolean isPrime(int numero) {
        int cont = 0;
        boolean ver = false;
        for (int i = 1; i <= numero; i++) {
            if ((numero % i) == 0) {
                cont++;
            }
        }
        if (cont == 2) {
            ver = true;
        }
        return ver;
    }//fin metodo isPrime

    public static int countPrimeFactors(int numero) {
        int cont = 0;
        boolean prime;
        for (int i = 1; i <= numero; i++) {
            prime = isPrime(i);
            if (prime == true && (numero % i == 0)) {
                cont++;
            }

        }
        return cont;
    }//fin metodo countPrimeFactros

    public static int[] getTotalPrimeCount(int[] array) {
        int[] temporal = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temporal[i] = countPrimeFactors(array[i]);
        }
        return temporal;
    }// fin metodo getTotalPrimeCount

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*****MENU*****");                                 //Menu
        System.out.println("1. Conjuntos");
        System.out.println("2. ¿Cuántos primos tienes?");
        System.out.println("3. Salir del programa");
        System.out.println("Ingresar una opcion: ");        
        int opcion = var.nextInt();                                             //Seleccion de programas
        while (opcion > 0 && opcion < 3) {                                      //valida los valores de la opcion de usuario, si el valor no es aceptado sacara al usuario del programa

            switch (opcion) {
                case 1://Conjuntos
                    System.out.println("Ingrese el tamaño de SET1: ");
                    int SET1_size = var.nextInt();                          //Asignacion de tamaño de SET1
                    System.out.println("Ingrese el tamaño de SET2: ");
                    int SET2_size = var.nextInt();                          //Asignacion de tamaño de SET2
                    System.out.println("Conjuntos generados:");
                    char[] SET1 = setAleatorio(SET1_size);              //Asignacion de valores de SET1
                    System.out.print("SET1: ");
                    printChar(SET1);                                      //Imprimir SET1 con formato
                    char[] SET2 = setAleatorio(SET1_size);              //Asignacion de valores de SET2
                    System.out.print("SET2: ");
                    printChar(SET2);                                      //Imprimir SET2 con formato
                    System.out.println("Que operacion desea usar: ");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    int opcion2 = var.nextInt();                            //Decision de operaciion por usuario
                    switch (opcion2) {
                        case 1:
                            char[] res = interseccion(SET1, SET2);         //Llamar el metodo para intersectar los dos arrays
                            printChar(res);
                            break;

                        case 2:
                            res = diferencia(SET1, SET2);           //Llamar el metodo para diferenciar los dos arrays
                            printChar(res);
                            break;
                    }

                    break;//Fin Conjuntos

                case 2://¿Cuántos primos tienes?
                    System.out.print("Ingrese el tamaño del array: ");
                    int size = var.nextInt();                                   //Asigna el tamaño del array
                    while (size < 2) {                                          //Verifica que el tamaño sea mayor a 1
                        System.out.println("El valor tiene que ser mayor que 1");
                        System.out.println("Ingrese otro valor mayor a 1");
                        size = var.nextInt();
                    }
                    System.out.println("Ingrese un minimo: ");
                    int min = var.nextInt();                                    //Asigna un minimo al rango de valores random que pueden salir
                    System.out.println("Ingrese un maximo: ");
                    int max = var.nextInt();                                    //Asignan un maximo al rango de valores random que pueden salir
                    while (min >= max) {                                        //Verifica que el maximo no sea menor o igual que el minimo
                        System.out.println("El maximo no puede ser menor o igual al minimo");
                        System.out.println("Ingrese otro valor: ");
                        max = var.nextInt();
                    }
                    int[] array = new int[size];
                    System.out.print("Conjunto generado: ");
                    array = getRandArray(size, max, min);                       //Le asigna los valores a el arreglo
                    printInt(array);                                            //Imprime los valores asignados
                    System.out.println();
                    System.out.print("No. de divisores primos: ");            
                    int[] divisores = new int[array.length];                    
                    divisores = getTotalPrimeCount(array);                      //Entra a las funciones que verifican y cuentan cuantos divisores primos tiene un numero
                    printInt(divisores);                                   //Imprime un arreglo con la cuenta de divisores primos que fueron contados en la funcion countPrimeFactors y los asigna en la posicion del numero que provinieron
                    System.out.println();
                    break;//Fin ¿Cuántos primos tienes?

            }
            System.out.println("*****MENU*****");                             //Menu
            System.out.println("1. Conjuntos");
            System.out.println("2. ¿Cuántos primos tienes?");
            System.out.println("3. Salir del programa");
            System.out.println("Ingresar una opcion: ");
            opcion = var.nextInt();                                             //Seleccion de programas
        }
    }

}
