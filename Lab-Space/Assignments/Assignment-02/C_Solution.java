
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int len1 = Integer.parseInt(br.readLine());
        int arr1[] = new int[len1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len1; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        int len2 = Integer.parseInt(br.readLine());
        int arr2[] = new int[len2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len2; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        int arr[] = new int[len1 + len2];
        int pos = 0, a = 0, b = 0;
        while (a < len1 && b < len2) {
            if (arr1[a] <= arr2[b]) {
                arr[pos++] = arr1[a++];
            }
            else {
                arr[pos++] = arr2[b++];
            }
        }

        while (a < len1) {
            arr[pos++] = arr1[a++];
        }
        while (b < len2) {
            arr[pos++] = arr2[b++];
        }

        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.flush();
    }
}
