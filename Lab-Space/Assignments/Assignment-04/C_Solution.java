
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int mat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            
            int k = Integer.parseInt(st1.nextToken());
            for (int j = 0; j < k; j++) {
                int dest = Integer.parseInt(st1.nextToken());
                mat[i][dest] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(mat[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}
