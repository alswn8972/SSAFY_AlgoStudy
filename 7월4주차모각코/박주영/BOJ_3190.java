import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_3190 {
    static int N, K, L, curDir = 0;//우로 시작
    static int[] dx = {0,1,0,-1};//우 하 좌 상
    static int[] dy = {1,0,-1,0};
    static int[][] map, dirs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1; //apple
        }
        L = Integer.parseInt(br.readLine());
        dirs = new int[L][2];
        for(int i = 0; i<L; i++){
            st = new StringTokenizer(br.readLine()," ");
            int sec = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().equals("D")?1:-1; //오른쪽:1, 왼쪽:0
            dirs[i][0] = sec;
            dirs[i][1] = dir;
        }

        Deque<int[]>deque = new ArrayDeque<>();
        deque.addFirst(new int[]{1,1}); //시작위치
        map[1][1] = -1; //뱀

        int answer = 0; // 흐른 시간
        int changeIdx = 0; //방향바꿀
        while(!deque.isEmpty()){
            int[] head = deque.peekFirst(); // 뱀 머리
            answer++;
            int nr = head[0] + dx[curDir];
            int nc = head[1] + dy[curDir];

            if(nr<1 || nc<1 || nr> N || nc> N) break; //벽에 부딪혀서 게임 종료
            //if(deque.contains(new int[]{nr,nc})) break; //자기 몸에 부딪혀서 게임 종료
            if(map[nr][nc] == -1) break;
            if(map[nr][nc] == 1) {//사과이면
                map[nr][nc] = -1; //사과 먹고
            }
            else{
                //꼬리 비워줌
                if(!deque.isEmpty()){
                    int[] tail = deque.pollLast();
                    map[tail[0]][tail[1]] = 0;
                }
            }
            deque.addFirst(new int[]{nr,nc});
            map[nr][nc] = -1;

            if(changeIdx<L && answer == dirs[changeIdx][0]){//방향 바꾸고 chTime갱신
                curDir = (curDir+dirs[changeIdx][1]+4)%4;
                changeIdx++;
            }
        }

        System.out.println(answer);
    }
}
