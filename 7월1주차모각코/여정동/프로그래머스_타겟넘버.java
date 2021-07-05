class Solution {
    
    static int t, l, r;
    static int[] nb;
    
    static void dfs(int depth, int sum){
        if(depth == l){
            if(sum == t){
                r++;
            } 
            return;
        }
        else{
            dfs(depth+1,sum + nb[depth]);
            dfs(depth+1,sum - nb[depth]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        r = 0;
        t = target;
        l = numbers.length;
        nb = numbers;
        dfs(0,0);
        answer = r;
        return answer;
    }
}