import java.util.*;
class Solution3 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] count = new double[N+1];
        for(int i : stages){
            if(i == N+1)continue;
            count[i]++;
        }

        ArrayList<Double> fail = new ArrayList<Double>();
        double num = stages.length;

        for(int i=1; i<count.length; i++){
            //tmp = count[i];
            if(num == 0)
                count[i]=0;
            else{
                int tmp = (int)count[i];
                count[i] = count[i]/num;

                num -= tmp;
            }

            fail.add(count[i]);
        }

        Collections.sort(fail,Collections.reverseOrder());

        for(int i=0; i<fail.size(); i++){
            for(int j=1; j<count.length; j++){
                if(fail.get(i) == count[j]){
                    answer[i] = j;
                    count[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
public class programmers_실패율 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] ans = sol.solution(N, stages);
        System.out.println(Arrays.toString(ans));
    }
}
