import java.util.Scanner;

public class BOJ_9663 {
    static int n, map[], cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n];
        cnt = 0;

        nqueen(0);
        System.out.println(cnt);
    }

    private static void nqueen(int row) {
        if(row == n){
            cnt++;
            return;
        }

        for(int col = 0; col<n; col++){
            map[row] = col;
            if(canQueen(row)){ // row행 col열에 queen 놓을 수 있다면
                nqueen(row+1); // 다음행
            }
        }
    }

    private static boolean canQueen(int row) {
        int curCol = map[row];
        for(int i = 0; i<row; i++){
            if(curCol == map[i]) // 같은 열
                return false;
            if(Math.abs(row-i) == Math.abs(curCol-map[i])) // 대각선상
                return false;
        }
        return true;
    }
}
