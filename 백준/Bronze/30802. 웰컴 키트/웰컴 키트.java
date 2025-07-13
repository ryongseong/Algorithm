import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sizes = new int[6];

        for (int i = 0; i < 6; i++) {
            sizes[i] = sc.nextInt();
        }
        sc.nextLine();
        int T = sc.nextInt();
        int P = sc.nextInt();
        sc.close();

        int minTShirt = 0;
        for (int i = 0; i < 6; i++) {
            double count = (double) sizes[i] / T;
            minTShirt += (int) Math.ceil(count);
        }
        System.out.println(minTShirt);
        System.out.printf("%d %d", N / P, N % P);
    }
}