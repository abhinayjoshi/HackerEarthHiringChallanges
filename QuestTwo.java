import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestTwo {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        String[] tempData = s.nextLine().split(" ");
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(tempData[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] tempArray = new int[n];
            for (int j = i; j < n; j++) {
                if (i == j) {
                    tempArray[j] = data[j];
                    if (isPerfectSquare(tempArray[j])) result++;
                } else {
                    tempArray[j] = data[j] + tempArray[j - 1];
                    if (isPerfectSquare(tempArray[j])) result++;
                }
            }
        }
        System.out.print(result);
    }

    private static boolean isPerfectSquare(int i) {
        double sr = Math.sqrt(i);
        return ((sr - Math.floor(sr)) == 0);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
