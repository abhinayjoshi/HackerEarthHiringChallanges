import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ByjuOne {

    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        String[] stallArray = s.nextLine().split(" ");
        int[] stalls = new int[n];
        for (int i = 0; i < n; i++){
            stalls[i] = Integer.parseInt(stallArray[i]);
        }
        int q = s.nextInt();
        int[] queries = new int[n];
        for (int i = 0; i < q; i++){
            queries[i] = s.nextInt();
        }

        for(int i = 0; i < q; i++){
            System.out.println(calculateValue(stalls, queries[i]));
        }
    }

    private static int calculateValue(int[] stalls, int query) {
        int min = (query / stalls.length) + 1;
        int max;
        if (query > stalls.length )
             max = query - stalls.length - 1;
        else max = 1;
        for( int j = min; j <= max; j++){
            int total = 0;
            for (int stall : stalls) {
                if (stall > j) {
                    total += j;
                } else
                    total += stall;
            }
            if (total >= query){
                return j;
            }
        }
        return -1;
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
