package programmers;

public class N�����ѱݾװ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.solution(3,20,4));
	}
	
	static class Solution {
	    public static long solution(int price, int money, int count) {
	    	//ù°�� price ���� price
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
