import java.util.Scanner;

public class BOJ_2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        int p = 2;
        int[] arr = new int[n+1];
        for(int i = 2; i<n+1; i++) arr[i] = i;

        while(cnt<k){
            for(int i = 2; i<n+1; i++){
                if(arr[i] == -1)continue;
                p = i;
                break;
            }
            for(int i = 1; i<n+1; i++){
                if(p*i>n)break;
                if(arr[p*i]==-1)continue;
                cnt++;
                if(cnt == k){
                    System.out.println(arr[p*i]);
                    break;
                }
                arr[p*i] = -1;
            }
        }
    }
}
