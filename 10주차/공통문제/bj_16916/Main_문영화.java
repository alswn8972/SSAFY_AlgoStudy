import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_문영화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		System.out.println(KMP(a,b));
	}
	public static int KMP(String str, String pattern) {
		
		int strlen = str.length();
		int ptlen = pattern.length();
		int j=0;
		char[] strArr = str.toCharArray();
		char[] ptArr = pattern.toCharArray();
		int[] fail = failFuc(pattern);
		
		for(int i=0;i<strlen;i++) {
			while(j>0&& strArr[i] != ptArr[j]) {
				j=fail[j-1];
			}
			if(strArr[i]==ptArr[j]) {
				if(j==ptlen-1) {
					return 1;
				}else {
					j++;
				}
			}
		}
		
		return 0;
	}
	public static int[] failFuc(String str) {
		int len = str.length();
		int j=0;
		int[] failArr = new int[len];
		char[] c = str.toCharArray();
		
		for(int i=1;i<len;i++) { // 한글자는 접미사 접두사 불가 1부터 시작
			while(j>0 && c[i]!=c[j]) {
				j=failArr[j-1];
			}
			if(c[i]==c[j]) {
				failArr[i]=++j;
			}
		}
		
		return failArr;
	}

}
