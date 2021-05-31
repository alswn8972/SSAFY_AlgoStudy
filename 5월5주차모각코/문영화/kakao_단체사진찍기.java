package programers;

public class kakao_단체사진찍기 {
	public static char[] kakaoF ={'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};     
    public static char[] temp;
    public static boolean[] check;
    public static String[] datas;
    public static int answer;
	public static void main(String[] args) {
		String[] tt= { "A~T=7"};
		System.out.println(solution(3,tt));
	}
	 public static int solution(int n, String[] data) {
	        datas=data;
	        temp=new char[8];
	        check=new boolean[8];
	        answer=0;
	        permu(0);
	        
	        return answer;
	    }
	 public static boolean check(int dis, int target, char ch) {
		 if(ch=='='&&dis==target){
			 return true;
         }else if(ch=='>'&&dis>target){
        	 return true;
         }else if(ch=='<'&&dis<target){
        	 return true;
         }
		 return false;
	 }
	 public static void permu(int n){
	        if(n==8){
	            char[] con;
	            int dis=0;
	            for(int k=0;k<datas.length;k++){
	            	con=new char[5];
	                for(int m=0;m<datas[k].length();m++) {
	                	con[m]=datas[k].charAt(m);
	                }
	                
	                int a=0;
	                int b=0;
	                for(int j=0;j<8;j++){
	                    if(temp[j]==con[0]){
	                        a=j;
	                    }else if(temp[j]==con[2]) {
	                    	b=j;
	                    }
	                }
	                dis=Math.abs(a-b)-1;
	                if(!check(dis,con[4]-'0',con[3])) {
	                	return;
	                }
	            }
	            answer++;
	            return;
	        }
	        for(int i=0;i<8;i++){
	            if(check[i]) continue;
	            temp[n]=kakaoF[i];
	            check[i]=true;
	            permu(n+1);
	            check[i]=false;
	        }
	    }

}
