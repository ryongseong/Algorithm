import java.io.*;
import java.util.*;

public class Main {
    static int num[], result[];
	static StringBuilder str = new StringBuilder();
	public static void backtracking(int cnt, int start, int N, int M) {
		if(cnt == M) {
			for (int num : result)
				str.append(num + " ");
			str.append("\n");
			return;
		}
		int n = 0;
		for (int i = start; i < N; i++) {
			if(n == num[i]) continue;
			result[cnt] = num[i];
			backtracking(cnt+1, i, N, M);
			n = num[i];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		num = new int[N];
		int M = Integer.parseInt(st.nextToken());
		result = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken()); 
		
		Arrays.sort(num);
		
		backtracking(0, 0, N, M);
		System.out.println(str);
		br.close();
	}
}


