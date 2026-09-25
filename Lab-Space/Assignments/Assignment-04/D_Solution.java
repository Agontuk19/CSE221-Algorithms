
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int degree[] = new int[n + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            degree[Integer.parseInt(st2.nextToken())]++;
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            degree[Integer.parseInt(st3.nextToken())]++;
        }

        int oddDegree = 0;
        for (int i = 1; i <= n; i++) {
            if ((degree[i] & 1) == 1) oddDegree++;
        }

        if (oddDegree == 0 || oddDegree == 2) {
            pw.print("YES");
        }
        else {
            pw.print("NO");
        }
        pw.flush();
    }
}
