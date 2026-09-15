
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
        int target = Integer.parseInt(st1.nextToken());

        int arr[] = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        boolean found = false;
        int str = 0, end = n - 1;
        while (str < end) {
            int sum = arr[str] + arr[end];
            if (sum == target) {
                pw.println((str + 1) + " " + (end + 1));
                found = true;
                break;
            }
            else if (sum < target) {
                str++;
            }
            else {
                end--;
            }
        }
        if(!found) {
            pw.println("-1");
        }
        pw.flush();
    }
}