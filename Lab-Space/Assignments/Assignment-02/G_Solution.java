import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G_Solution {
    public static boolean isValid(int [] arr, int n, int k, long maxVal) {
        int parts = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                return false;
            }

            if (sum + arr[i] <= maxVal) {
                sum += arr[i];
            }
            else {
                parts++;
                sum = arr[i];
            }
        }
        return parts <= k;
    }
    public static long splitArray(int [] arr, int n, int k) {
        if (k > n) {
            return -1;
        }

        long totalSum = 0;
        for (int x: arr) {
            totalSum += x;
        }

        long left = 0;
        long right = totalSum;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isValid(arr, n , k, mid)) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        pw.println(splitArray(arr, n, k));
        pw.flush();
    }
}
