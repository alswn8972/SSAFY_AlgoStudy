import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2876_강민주 {
   static int N;
   static int[][] arr;
   static int result_grade, result_count;
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      
      N = Integer.parseInt(bf.readLine());
      
      arr = new int[N+1][2];
      result_grade = 0;
      result_count=0;
      StringTokenizer st;
      for(int i =0; i < N; ++i) {
         st = new StringTokenizer(bf.readLine());
         arr[i][0] = Integer.parseInt(st.nextToken());
         arr[i][1] = Integer.parseInt(st.nextToken());
      }
      
      for(int i = 1; i<= 5; ++i) { // 점수
         int count = 0;
         //연속되는 모든 행렬 체크
         for(int j = 0; j < N; ++j) { // 책상 줄
            // 두명중에 한명이라도 이점수에 해당 되어야함
            if(arr[j][0] == i || arr[j][1] == i) count++;
            // 없으면 초기화
            else count = 0;
            
            if(count > result_count) {
               result_count = count;
               result_grade = i;
            }            
         }
      }      
      System.out.println(result_count + " "  +result_grade );
   }

}