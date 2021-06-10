import java.util.Scanner;

public class BOJ_2447 {
    static char[][]map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++)
                map[i][j] = ' ';
        }
        solution(0,0,n);
        StringBuilder sb = new StringBuilder();
        for(char[] c: map){
            for(char cc: c){
                sb.append(cc);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void solution(int x, int y, int n) {
        if(n==3){
            map[x][y] = '*';
            map[x][y+1] = '*';
            map[x][y+2] = '*';
            map[x+1][y] = '*';
            map[x+1][y+2] = '*';
            map[x+2][y] = '*';
            map[x+2][y+1] = '*';
            map[x+2][y+2] = '*';
        }
        else {
            int next = n / 3;
            solution(x, y, next);
            solution(x, y + next, next);
            solution(x, y + 2 * next, next);

            solution(x + next, y, next);
            solution(x + next, y + 2 * next, next);

            solution(x + 2 * next, y, next);
            solution(x + 2 * next, y + next, next);
            solution(x + 2 * next, y + 2 * next, next);
        }
    }
}
