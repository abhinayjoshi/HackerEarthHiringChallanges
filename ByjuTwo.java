import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ByjuTwo {


    public static void main(String[] args) {
//        FastReader s = new FastReader();
//        int n = s.nextInt();
//        int[] noOfEmployees = new int[n];
//        int[] budget = new int[n];
//        for (int i = 0; i < n; i++){
//            String[] tempData = s.nextLine().split(" ");
//            noOfEmployees[i] = Integer.parseInt(tempData[1]);
//            budget[i] = Integer.parseInt(tempData[0]);
//        }
//
//        int result = 0;
//        for (int i = n-1; i >= 0; i--){
//            if (((budget[i]+result) % noOfEmployees[i]) != 0) {
//                result += (noOfEmployees[i] - ((budget[i] + result) % noOfEmployees[i]));
//            }
//        }
        solve(10.25,17,5);
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
            double ans;
            ans =  (meal_cost + (float)(meal_cost*tax_percent/100) + (float)(meal_cost*tip_percent/100));
            System.out.print(Math.round(ans));

                int N = 0;
                if(N % 2 == 0){
                    if( N <= 5 && N >=2){
                        System.out.print("Not Weird");
                    }
                    else if( N <= 20 && N >=6){
                        System.out.print("Weird");
                    }
                    else if( N > 20){
                        System.out.print("Not Weird");
                    }
                }
                else System.out.print("Weird");

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}


