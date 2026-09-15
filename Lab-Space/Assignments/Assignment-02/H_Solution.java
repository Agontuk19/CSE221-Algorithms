
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H_Solution {
    public static boolean isValid(int arr[], long k, int len) {
        long piece = 0;

        for (int x: arr) {
            piece += x/len;
            if (piece >= k) return true;
        }
        return false;
    }
    public static int splitRope(int arr[], int n, long k) {
        int left = 1;
        int right = -1;
        for (int x: arr) {
            right = Math.max(x, right);
        }

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(arr, k, mid)) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        long k = Long.parseLong(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        pw.println(splitRope(arr, n, k));
        pw.flush();
    }
}
