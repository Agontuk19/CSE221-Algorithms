import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Solution {
    static long ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            long L = Long.parseLong(st.nextToken());
            long H = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());

            long[] arr = new long[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            ans = 0;
            mergeSort(arr, L, H);

            out.println(ans);
        }
        out.flush();
    }
    public static long[] mergeSort(long[] arr, long L, long H) {
        if (arr.length <= 1)
            return arr;

        int mid = arr.length / 2;
        long[] left = new long[mid];
        long[] right = new long[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[mid - i] = arr[i];
        }

        left = mergeSort(left, L, H);
        right = mergeSort(right, L, H);

        countPairs(left, right, L, H);
        return merge(left, right);
    }

    public static void countPairs(long[] left, long[] right, long L, long H) {
        int low = 0; 
        int high = 0;
        for (int j = 0; j < right.length; j++) {
            while (low < left.length)
        }
    }

    public static long[] merge(long[] left, long[] right) {
        long[] arr = new long[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return arr;
    }
}