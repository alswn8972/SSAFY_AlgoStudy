package programmers;

import java.util.*;

public class 짝지어_제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int ans=0;
    public int solution(String s){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!stack.empty()&&stack.peek()==s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.empty()){
            return 1;
        }else{
            return 0;
        }
       

        
    }
    //dfs 효율성 초과 됨
    public void dfs(String s){
        if(s.length()==0){
            ans=1;
            return;
        }
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                String sf = s.substring(0,i-1);
                String pf = s.substring(i+1,s.length());
                String str = sf+pf;
                dfs(str);
                break;
            }
        }
        
    }

}
