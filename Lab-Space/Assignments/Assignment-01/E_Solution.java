
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E_Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<String> swap = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 2 - i; j++) {
                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                    swap.add((j + 1) + " " + (j + 3));
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            pw.println("YES");
            pw.println(swap.size());
            for (int i = 0; i < swap.size(); i++) {
                pw.println(swap.get(i));
            }
        }
        else {
            pw.println("NO");
        }
        pw.flush();
    }
}
