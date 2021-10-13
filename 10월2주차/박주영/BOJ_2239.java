import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2239 {
    static int[][] map = new int[9][9];
    static ArrayList<int[]> zeros = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<9; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<9; j++){
                map[i][j] = tmp[j] - '0';
                if(map[i][j] == 0){
                    zeros.add(new int[]{i,j});
                }
            }
        }

        recursion(0);
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void recursion(int idx){
        if(idx >= zeros.size()){
            print();
            System.exit(0);
        }

        int r = zeros.get(idx)[0];
        int c = zeros.get(idx)[1];

        for (int k = 1; k < 10; k++) {
            if (checkRowColBox(r, c, k)) { // k가 [i,j]에 가능한 값이면
                int origin = map[r][c];
                map[r][c] = k;
                recursion(idx+1);
                map[r][c] = origin;
            }
        }

    }

    private static boolean checkRowColBox(int r, int c, int value) {
        boolean res = true;

        // row
        for(int i = 0; i<9; i++){
            if(map[r][i] == value)return false;
        }
        // col
        for(int i = 0; i<9; i++){
            if(map[i][c] == value)return false;
        }
        // box
        int rangeR = (r/3)*3;
        int rangeC = (c/3)*3;
        for(int i = rangeR; i<rangeR+3; i++){
            for(int j = rangeC; j<rangeC+3; j++){
                if(map[i][j] == value) return false;
            }
        }

        return res;
    }
}
