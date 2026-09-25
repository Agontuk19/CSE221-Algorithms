import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Solution {
    static long[] bit;
    static int m;
    static void update(int idx) {
        while (idx <= m) {
            bit[idx]++;
            idx += idx & (-idx);
        }
    }

    static long query(int idx) {
        long sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & (-idx);
        }
        return sum;
    }

    // Find rank of x (1-indexed)
    static int getRank(int[] arr, int size, int x) {
        int l = 0, r = size - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x)
                return mid + 1;
            if (arr[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // Number of elements <= x
    static int upperBound(int[] arr, int size, long x) {
        int l = 0;
        int r = size;
        while (l < r) {
            int mid = (l + r) / 2;
            if ((long) arr[mid] <= x)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }


    // Merge Sort
    public static void mergeSort (int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp [] = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for(k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr [] = new int[n];
        int temp [] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            temp[i] = arr[i];
        }

        // Sorting
        mergeSort(temp, 0, arr.length - 1);

        // Remove duplicates
        int uniq[] = new int[n];
        m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || temp[i] != temp[i - 1]) {
                uniq[m++] = temp[i];
            }
        }

        bit = new long[m + 1];
        long answer = 0;
        long inserted = 0;
        for (int i = 0; i < n; i++) {
            long square = 1L * arr[i] * arr[i];
            int pos = upperBound(uniq, m, square);
            answer += inserted - query(pos);
            int rank = getRank(uniq, m, arr[i]);
            update(rank);
            inserted++;
        }
        pw.println(answer);
        pw.flush();
    }
}
