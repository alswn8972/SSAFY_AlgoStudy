package programers;

import java.util.Stack;

public class kakao_괄호변환 {

	public static void main(String[] args) {
		String s = "()))((()";
		System.out.println(solution(s));

	}

	public static String solution(String p) {
		return make(p);
	}
	public static String make(String p) {
		String answer = "";
		if (p.equals("")||right(p)) {
			return p;
		} 
		int mid=mid(p);
		String u=p.substring(0,mid);
		String v=p.substring(mid,p.length());
		if(right(u)) {
			answer= u+make(v);
		}else {
			answer="("+make(v)+")"+revise(u.substring(1,u.length()-1));
		}
		return answer;
	}
	public static int mid(String p) {
		int front = 0;
		int end = 0;
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (c == '(')
				front++;
			else
				end++;
			if (front == end) {
				return i + 1;
			}
		}
		return -1;
	}

	public static String revise(String s) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='(') sb.append(")");
			else sb.append("(");
		}

		return sb.toString();
	}

	public static boolean right(String r) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < r.length(); i++) {
			char c = r.charAt(i);
			if (c == '(')
				stack.add(c);
			else if (c == ')' && stack.isEmpty())
				return false;
			else if (c == ')')
				stack.pop();
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
