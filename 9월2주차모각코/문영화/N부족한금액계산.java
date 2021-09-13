package programmers;

public class N부족한금액계산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.solution(3,20,4));
	}
	
	static class Solution {
	    public static long solution(int price, int money, int count) {
	    	//첫째항 price 공차 price
	    	long last = price*count;
	    	long total = ((price+last)*count)/2;
	        long answer = total-money;
	        
	        if(answer<0) {
	        	return 0;
	        }
	        return answer;
	    }
	}

}
