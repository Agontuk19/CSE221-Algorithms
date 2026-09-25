
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F_Solution {
    static int arr[];
    static StringBuilder ans = new StringBuilder();

    public static void solve(int l, int r) {
        if (l > r) return;
        int mid = l + (r - l) / 2;

        ans.append(arr[mid]).append(" ");
        solve(l, mid - 1);
        solve(mid + 1, r);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        solve(0, n-1);
        pw.println(ans.toString().trim());
        pw.flush();
    }
}
