package programers;

public class kakao_n진수게임 {

	public static void main(String[] args) {
//		int ten =11;
//		int n=-1;
//		String s="";
//		while(true) {
//			if(ten/3==0) {
//				s+=ten%3;
//				break;	
//			}
//			n=ten%3;
//			ten=(ten/3);
//			s+=n;
//			
//		}
//		System.out.println(s);
		
		System.out.println(solution(16,16,2,1));
	}
	// n이 진법, t미리 구할 숫자개수,m 게임에 참가하는 인원, 튜브순서
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        int cnt=0;//진법으로 구해야하는 수
        StringBuffer sb;
        String total="";
        
        while(cnt<t*m) {
        	sb= new StringBuffer();
        	int mod;
        	int tempnum=cnt;
        	while(true) {
        		mod=tempnum%n;
        		if(tempnum/n==0) {
        			sb.append(numbers[mod]);
        			break;
        		}
        		tempnum=tempnum/n;
        		sb.append(numbers[mod]);
        	}
        	total+=sb.reverse().toString();
        	cnt++;
        }
        int x=1;
        cnt=0;
        for(int i=0;i<total.length();i++) {
        	if(x==p) {
        		answer+=total.charAt(i);
        		cnt++;
        		if(cnt==t) {
        			break;
        		}
        	}
        	if(x==m) {
        		x=1;
        	}else {
        		x++;
        	}
        }
        return answer;
    }
}
