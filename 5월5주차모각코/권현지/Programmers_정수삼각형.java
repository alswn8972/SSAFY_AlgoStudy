import java.io.IOException;

class Programmers_Á¤¼ö»ï°¢Çü {
	
	public static void main(String[] args) throws IOException {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		int answer = solution(triangle);
		System.out.println(answer);
	}
    public static int solution(int[][] triangle) {
    	int answer = 0;
    	int N = triangle.length;
    	int[][] DP = new int[500][500];

    	DP[0][0] = triangle[0][0];
    	for(int i = 1; i<triangle.length; i++){
    		for(int j = 0; j<triangle[i].length; j++){
    			if(j == 0){
    				DP[i][j] = DP[i-1][j] + triangle[i][j];
    			}
    			else if(j == triangle[i].length-1){
    				DP[i][j] = DP[i-1][j-1] + triangle[i][j];
    			}
    			else{
    				DP[i][j] = Math.max(DP[i-1][j] + triangle[i][j],DP[i-1][j-1] + triangle[i][j]);
    			}
    			
    		}
    	}
    	for(int i = 0; i<triangle[N-1].length; i++){
    		answer = Math.max(answer,DP[N-1][i]);
    		}
    	return answer;
    }
    
}