import java.io.*;
import java.util.StringTokenizer;

public class A_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            if (a % 2 == 0) {
                pw.println(a + " is an Even number.");
            }
            else {
                pw.println(a + " is an Odd number.");
            }
        }
        pw.flush(); 
    }
}
