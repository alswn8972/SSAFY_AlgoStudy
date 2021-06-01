import java.util.*;

class kakao_가장먼노드 {
    
    static Node[] node;
    static boolean[] iv;
    static int max = 0;
    static int count = 0;
    static Queue<Finder> q = new LinkedList<Finder>();
    
    public void bfs(){
        q.clear();
        q.offer(new Finder(node[1], 0));
        
        while(!q.isEmpty()){
            Finder now = q.poll();
            if(max < now.depth){
                count = 1;
                max = now.depth;
            }
            else if(max == now.depth){
                count++;
            }
            
            for(int i = 0; i < now.node.edges.size(); i++){
                int next = now.node.edges.get(i);
                if(!iv[next]){
                    iv[next] = true;
                    q.offer(new Finder(node[next], now.depth+1));
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        count = 0;
        node = new Node[n+1];
        for(int i = 1; i <= n; i++){
            node[i] = new Node(i);
        }
        
        for(int i = 0; i < edge.length; i++){
            node[edge[i][0]].edges.add(edge[i][1]);
            node[edge[i][1]].edges.add(edge[i][0]);
        }
        
        iv = new boolean[n+1];
        iv[1] = true;
        bfs();
        
        return count;
    }
    
    static class Finder{
        Node node;
        int depth;
        Finder(Node node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    
    static class Node{
        int no;
        List<Integer> edges;
        Node(int no){
            this.no = no;
            edges = new ArrayList<Integer>();
        }
    }
}