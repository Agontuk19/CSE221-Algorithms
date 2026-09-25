import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        int knights[][] = new int[k][2];
        boolean board[][] = new boolean[n + 1][m + 1]; 

        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            board[x][y] = true;
            knights[i][0] = x;
            knights[i][1] = y;
        }

        int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < k; i++) {
            int x = knights[i][0];
            int y = knights[i][1];
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if ((nx > 0 && nx <= n) && (ny > 0 && ny <= m)) {
                    if (board[nx][ny]) {
                        pw.println("YES");
                        pw.flush();
                        return;
                    }
                }
            }
        }
        pw.println("NO");
        pw.flush();
    }
}
