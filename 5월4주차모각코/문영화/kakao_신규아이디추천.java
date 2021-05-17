package programers;


public class kakao_신규아이디추천 {
	public static void main(String[] args) {
		String s ="...!@BaT#*..y.abcdefghijklm";
		s= s.toLowerCase();
		s=s.replaceAll("[^a-z0-9._-]","");
		
		StringBuffer sb = new StringBuffer(s);
		
		
		for(int i=1;i<sb.length();i++) {
			if(sb.charAt(i-1)=='.'&&sb.charAt(i)=='.') {
				sb.delete(i-1, i);
				i--;
			}
		}
		if(sb.length()!=0&&sb.charAt(0)=='.')
			sb.delete(0, 1);
		if(sb.length()!=0&&sb.charAt(sb.length()-1)=='.')
			sb.delete(sb.length()-1,sb.length());
		if(sb.length()==0) {
			sb.append("a");
		}
		if(sb.length()>15) {
			sb.delete(15, sb.length());
			if(sb.charAt(sb.length()-1)=='.')
				sb.delete(sb.length()-1,sb.length());
		}
		if(sb.length()<3) {
			while(sb.length()<3) {
				sb.append(sb.charAt(sb.length()-1));
			}
		}
		System.out.println(sb.toString());
	}
}
