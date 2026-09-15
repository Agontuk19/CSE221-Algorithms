
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int prev = -1;
            boolean sorted = true;
            for (int j = 0; j < a; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (j != 0) {
                    if (prev > x) {
                        sorted = false;
                        break;
                    }
                }
                prev = x;
            }
            if (sorted) {
                pw.println("YES");
            }
            else {
                pw.println("NO");
            }
        }
        pw.flush();
    }
}
