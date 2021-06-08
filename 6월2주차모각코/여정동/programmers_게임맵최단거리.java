import java.util.*;

class kakao_게임맵최단거리 {
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        boolean[][] iv = new boolean[n+1][m+1];
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0,0,1));
        iv[0][0] = true;
        
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        boolean isFound = false;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.y == n && now.x == m){
                isFound = true;
                answer = now.move;
                break;
            }
            else {
                int ny;
                int nx;
                for(int d = 0; d < 4; d++){
                    ny = now.y + dy[d];
                    nx = now.x + dx[d];
                    if(ny <= n && nx <= m && ny >= 0 && nx >= 0 && !iv[ny][nx] && maps[ny][nx] == 1){
                        pq.offer(new Node(ny,nx,now.move+1));
                        iv[ny][nx] = true;
                    }
                }
            }
        }
        if(!isFound) answer = -1;
        
        return answer;
    }
    
    static class Node implements Comparable<Node>{
        int move;
        int y;
        int x;
        
        Node(int y, int x, int move){
            this.y = y;
            this.x = x;
            this.move = move;
        }
        
        @Override
        public int compareTo(Node n){
            return this.move - n.move;
        }
    }
    
}
