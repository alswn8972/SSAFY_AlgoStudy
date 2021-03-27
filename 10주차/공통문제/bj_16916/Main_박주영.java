
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_박주영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        System.out.println(kmp(S,P));
    }

    public static int kmp(String str, String pattern) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] pi = getPi(pattern);

        int n = str.length();
        int m = pattern.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    list.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return list.size()>0?1:0;
    }

    public static int[] getPi(String pattern) {
        int m = pattern.length();
        int j = 0;
        int[] pi = new int[m];

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }

        }
        return pi;
    }
}
