import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
    static int N;
    static int[][] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        origin = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<N; j++){
                origin[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] res = sol(B, origin);
        for(int[] i:res){
            for(int ii: i)
                System.out.print(ii+" ");
            System.out.println();
        }
    }

    private static int[][] multi(int[][] m1, int[][] m2){
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmp[i][j] += m1[i][k] * m2[k][j];
                    tmp[i][j] %= 1000;
                }
            }
        }
        return tmp;
    }

    private static int[][] sol(long n, int[][] matrix) {
        if(n==1)return matrix;

        int[][] tmp = sol(n/2, matrix);

        if(n%2==1){
            int[][] tmp2 = multi(tmp, tmp);
            return multi(origin, tmp2);
        }
        return multi(tmp, tmp);
    }
}
