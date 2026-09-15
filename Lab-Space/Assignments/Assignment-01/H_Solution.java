
import java.io.*;
import java.util.*;

public class H_Solution {
    static class Train {
        String line;
        String name;
        int minuteTime;
        int index;

        public Train(String ln, int idx) {
            line = ln;
            index = idx;

            String[] lineParts = line.split(" ");
            name = lineParts[0];

            String time = lineParts[lineParts.length - 1];
            String[] timeParts = time.split(":");
            minuteTime = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        Train[] trains = new Train[n];

        for(int i = 0; i < n; i++) {
            trains[i] = new Train(br.readLine(), i);
        }

        Arrays.sort(trains, (Train a, Train b) -> {
            int cmp = a.name.compareTo(b.name);
            
            if (cmp != 0) return cmp;
            if(a.minuteTime != b.minuteTime) return b.minuteTime - a.minuteTime;
            return a.index - b.index;
        });

        for (int i = 0; i < n; i++) {
            pw.println(trains[i].line);
        }
        pw.flush();
    }
}
