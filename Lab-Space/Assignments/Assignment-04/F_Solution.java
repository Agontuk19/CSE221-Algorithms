
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class F_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken()  );

        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1, -1,  0, 1};
        ArrayList<int[]> moves = new ArrayList<>();
        int count = 0; 

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx > 0 && nx <= n) && (ny > 0 && ny <= n)) {
                count++;
                moves.add(new int[]{nx, ny}); 
            }
        }

        pw.println(count);
        for (int[] p: moves) {
            pw.println(p[0] + " " + p[1]);
        }
        pw.flush(); 
    }
}
