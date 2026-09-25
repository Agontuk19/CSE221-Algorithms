import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] mat = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            
            int src = Integer.parseInt(st2.nextToken());
            int dest = Integer.parseInt(st2.nextToken());
            int wgt = Integer.parseInt(st2.nextToken());

            mat[src - 1][dest - 1] = wgt;
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