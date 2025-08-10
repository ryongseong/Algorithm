import java.io.*;
import java.util.*;


public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String kind = input[1];

                if (hashMap.containsKey(kind)) {
                    hashMap.put(kind, hashMap.get(kind) + 1);
                } else {
                    hashMap.put(kind, 1);
                }
            }
            int result = 1;
            for (int count : hashMap.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
            hashMap.clear();
        }
    }
}