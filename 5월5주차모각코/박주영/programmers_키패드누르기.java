import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    int[][] map={
            {3,1},
            {0,0}, {0,1}, {0,2},
            {1,0}, {1,1}, {1,2},
            {2,0}, {2,1}, {2,2},
    };
    int[] curL, curR;
    String answer;
    public String solution(int[] numbers, String hand) {
        int SIZE = numbers.length;
        curL = new int[]{3,0};
        curR = new int[]{3,2};

        answer = "";
        for(int i = 0; i<SIZE; i++){
            int num = numbers[i];
            if(num == 1 || num == 4 || num == 7) goL(num);
            else if(num == 3 || num == 6 || num == 9) goR(num);
            else{
                int disL = getDis(curL, map[num]);
                int disR = getDis(curR, map[num]);
                if(disL==disR){
                    if(hand.equals("left")) goL(num);
                    else goR(num);
                }
                else if(disL<disR)goL(num);
                else goR(num);
            }
        }

        return answer;
    }
    public int getDis(int[] a, int[] b){
        return (Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]));
    }
    public void goL(int num){
        answer+="L";
        curL = map[num];
    }
    public void goR(int num){
        answer+="R";
        curR = map[num];
    }
}
public class programmers_키패드누르기 {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
        int[] num = new int[11];
        for(int i = 0; i<11; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        String hand = br.readLine();
        s.solution(num,hand);
    }

}
