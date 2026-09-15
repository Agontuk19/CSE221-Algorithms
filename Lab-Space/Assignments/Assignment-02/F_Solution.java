import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F_Solution {
    public static int bound(int[] arr, int target, boolean upper) {
        int start = 0, end = arr.length - 1;
        int boundVal = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target || (!upper && arr[mid] == target)) {
                boundVal = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return boundVal;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int q = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int pair[] = new int[2];
            pair[0] = Integer.parseInt(st3.nextToken());
            pair[1] = Integer.parseInt(st3.nextToken());

            pw.println(bound(arr, pair[1], true) - bound(arr, pair[0], false));
        }
        pw.flush();
    }
}
