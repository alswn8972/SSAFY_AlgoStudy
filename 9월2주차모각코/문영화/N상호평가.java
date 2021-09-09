package programmers;

public class N상호평가 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x={{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};

		System.out.println(solution(x));
	}
	
	public static String solution(int[][] scores) {
        String answer = "";
        int max,min,total,avg;
        for(int i=0;i<scores.length;i++) {
        	max=0;
        	min=100;
        	total=0;
        	avg=0;
        	for(int j=0;j<scores.length;j++) {
        		if(i==j) continue;
        		max = Math.max(scores[j][i], max);
        		min = Math.min(scores[j][i], min);
        		total+=scores[j][i];
        	}
        	
        	if(scores[i][i]>max ||scores[i][i]<min) {
        		avg=total/(scores.length-1);
        	}else {
        		total+=scores[i][i];
        		avg=total/scores.length;
        	}
        	
        	if(avg>=90) {
        		answer+="A";
        	}else if(avg<90&&avg>=80) {
        		answer+="B";
        	}else if(avg<80&&avg>=70) {
        		answer+="C";
        	}else if(avg<70&&avg>=50) {
        		answer+="D";
        	}else{
        		answer+="F";
        	}
        }
        return answer;
    }

}
