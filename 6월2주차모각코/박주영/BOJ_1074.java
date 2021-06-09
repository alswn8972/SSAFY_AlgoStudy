import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int N,r,c,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,N);
        count = 0;

        solution(0,0, size);
    }

    private static void solution(int x, int y, int size) {
        if(x==r && y==c){
            System.out.println(count);
            return;
        }
        if(x<=r && r<x+size && y<=c && c<y+size){
            solution(x,y,size/2);
            solution(x,y+size/2,size/2);
            solution(x+size/2,y,size/2);
            solution(x+size/2,y+size/2,size/2);
        }
        else count += size*size;
    }
}
