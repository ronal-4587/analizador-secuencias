package app;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
            System.out.print("Ingrese tamaño del arreglo ");
            n = scanner.nextInt();
        int[] arreglo = Arreglo(n);

        int cantPrimos = Primos(arreglo);
        int max = maximo(arreglo);
        int[] posMax = posMaximo(arreglo);


        System.out.println("Arreglo: " + Arrays.toString(arreglo));
        System.out.println("Cantidad de números primos: " + cantPrimos);
        System.out.println("numero maximo del arreglo: " + max);
        System.out.println("posicion donde aparece el máximo: " + Arrays.toString(posMax));
    }


    public static int[] Arreglo(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[n];

        System.out.println("Ingrese " + n + " enteros:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }

    public static boolean esPrimo(int x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;

        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static int Primos(int[] a) {
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            if (esPrimo(a[i])) {
                cont++;
            }
        }
        return cont;
    }

    public static int maximo(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int[] posMaximo(int[] a) {
        int max = maximo(a);

        int rep = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) rep++;
        }

        int[] posi = new int[rep];
        int pos = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                posi[pos] = i;
                pos++;
            }
        }

        return posi;
    }
}