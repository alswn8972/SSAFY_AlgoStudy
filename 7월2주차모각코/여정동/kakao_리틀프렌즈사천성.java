import java.util.*;

class Solution {
    
    public String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        boolean[] alpha = new boolean[26];
        Pair[] pair = new Pair[26];
        Queue<Block> q = new LinkedList<Block>();
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        boolean[][] vi;
        int b_count = 0;
        char[][] map = new char[m][n];
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                char c = board[i].charAt(j);
                map[i][j] = c;
                if('A' <= c && c <= 'Z'){
                    if(alpha[c-'A']){
                        pair[c-'A'].list.add(new Block(i,j));
                    }
                    else{
                        b_count++;
                        alpha[c-'A'] = true;
                        pair[c-'A'] = new Pair();
                        pair[c-'A'].list.add(new Block(i,j));
                    }
                }
            }
        }
        
        boolean block_break = true;
        
        a:while(block_break && b_count > 0){
            block_break = false;
            b:for(int i = 0; i < 26; i++){
                if(alpha[i]){
                    q.clear();
                    vi  = new boolean[m][n];
                    Block start = pair[i].list.get(0);
                    Block goal = pair[i].list.get(1);
                    q.offer(start);
                    vi[start.y][start.x] = true;
                    char c = map[start.y][start.x];
                    
                    while(!q.isEmpty()){
                        Block now = q.poll();
                        if(now.y == goal.y && now.x == goal.x){
                            block_break = true;
                            alpha[i] = false;
                            map[start.y][start.x] = '.';
                            map[goal.y][goal.x] = '.';
                            answer.append(c);
                            --b_count;
                            break b;
                        }
                        
                        else{
                            int ny, nx;
                            for(int d = 0; d < 4; d++){
                                ny = dy[d] + now.y;
                                nx = dx[d] + now.x;
                                
                                if(ny < m && ny > -1 && nx < n && nx > -1 && !vi[ny][nx] && (map[ny][nx] == '.' || map[ny][nx] == c)){
                                    vi[ny][nx] = true;
                                    q.offer(new Block(ny, nx));
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if(b_count > 0) return "IMPOSSIBLE";        
        return answer.toString();
    }
    
    static class Pair{
        ArrayList<Block> list;
        Pair(){
            list = new ArrayList<Block>();
        }
    }
    
    static class Block{
        int y;
        int x;
        
        Block(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}


public class kakao_리틀프렌즈사천성 {
	public static void main(String[] args) {
		String[] s = {"DBA", "C*A", "CDB"};
		Solution sl = new Solution();
		String answer = sl.solution(3, 3, s);
		System.out.println(answer);
	}
}