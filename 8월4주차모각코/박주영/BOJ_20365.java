import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        ArrayList<Character> list = new ArrayList<>();
        char prev = ' ';
        for(int i = 0; i<n; i++){
            if(prev == input[i]) continue;
            list.add(input[i]);
            prev = input[i];
        }

        int b_cnt = 0, r_cnt = 0;
        for(char color: list){
            if(color == 'B')b_cnt++;
            else if(color == 'R')r_cnt++;
        }
        int ans = b_cnt<=r_cnt?b_cnt:r_cnt;
        System.out.println(ans+1);
    }
}
