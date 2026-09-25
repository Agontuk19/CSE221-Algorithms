import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class H_Solution {
    public static int gcd (int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int q = Integer.parseInt(st1.nextToken());

        ArrayList<Integer> adj[]= new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && (gcd(i, j) == 1)) {
                    adj[i].add(j);
                }
            }
        }

        while (q-- > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());

            if (k > adj[x].size()) {
                pw.println(-1);
            }
            else {
                pw.println(adj[x].get(k - 1));
            }
        }
        pw.flush();
    }
}
