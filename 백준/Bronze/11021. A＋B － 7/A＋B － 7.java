import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException
    {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
 
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        
		for (int idx = 1; idx <= a; idx++)
        {
			st = new StringTokenizer(br.readLine()," ");
			sb.append("Case #").append(idx).append(": ")
			.append(Integer.parseInt(st.nextToken())
			+Integer.parseInt(st.nextToken())).append('\n');
		}
		br.close();
		System.out.println(sb);
	}
}