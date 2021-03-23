import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_박주영 {
    static int SIZE = 32;
    static int A[] = new int[SIZE];
    static int B[] = new int[SIZE];

    private static void init(){
        A[1] = 1;
        A[2] = 0;
        A[3] = 1;

        B[1] = 0;
        B[2] = 1;

        for(int i = 4; i<SIZE; i++){
            A[i] = A[i-1]+A[i-2];
            int j = i-1;
            B[j] = B[j-1]+B[j-2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        init();

        int a = 1, b;
        while (true){
            if((K-a*A[D])%B[D] == 0){ //K = a*A[D] + b*B[D]
                b = (K-a*A[D])/B[D];
                break;
            }
            a++;
        }

        System.out.println(a);
        System.out.println(b);
    }
}
