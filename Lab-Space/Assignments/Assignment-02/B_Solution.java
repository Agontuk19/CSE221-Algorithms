import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len1 = Integer.parseInt(st.nextToken());
        int len2 = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr1[] = new int[len1];
        int arr2[] = new int[len2];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len1; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len2; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        int pair[] = new int[2];
        int lowestSum = Integer.MAX_VALUE;
        int start = 0, end = len2 - 1;
        while (start < len1 && end >= 0) {
            int sum = arr1[start] + arr2[end] - k;
            int absSum = Math.abs(sum);
            if (absSum < lowestSum) {
                lowestSum = absSum;
                pair[0] = start + 1;
                pair[1] = end + 1;
            }
            else if (sum > 0) {
                end--;
            }
            else {
                start++;
            }
        }
        pw.println(pair[0] + " " + pair[1]);
        pw.flush();
    }
}
