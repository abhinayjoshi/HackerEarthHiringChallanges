import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class QuestOne {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int testCase = s.nextInt();
        for (int i = 0; i < testCase; i++) {
            int taskNumber = s.nextInt();
            int[][] tasks = new int[taskNumber][3];
            for (int j = 0; j < taskNumber; j++) {
                String[] tempData = s.nextLine().split(" ");
                tasks[j][0] = Integer.parseInt(tempData[0]);
                tasks[j][1] = Integer.parseInt(tempData[1]);
                tasks[j][2] = 0;
            }
            sortbyColumn(tasks);
            int visited = 0;
            int alice = 0;
            int bob = 0;
            boolean chance = true;
            while (taskNumber != visited) {
                int l, m;
                l = 0;
                int result = 0;
                while (tasks[l][2] != 0)
                    l++;
                result++;
                for (m = 1; m < taskNumber; m++) {
                    if (tasks[m][0] >= tasks[l][1] && tasks[m][2] == 0) {
                        result++;
                        tasks[m][2] = 1;
                        l = m;
                    }
                }
                visited += result;
                if(chance){
                    alice = alice^result;
                    chance = false;
                }else {
                    bob = bob^result;
                    chance = true;
                }
            }
            if ( alice > bob){
                System.out.println("Alice");
            }else if ( bob > alice){
                System.out.println("Bob");
            }else
                System.out.println("Tie");

        }
    }

    private static void sortbyColumn(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(final int[] entry1,
                               final int[] entry2) {
                if (entry1[1] > entry2[1])
                    return 1;
                else
                    return -1;
            }
        });
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
