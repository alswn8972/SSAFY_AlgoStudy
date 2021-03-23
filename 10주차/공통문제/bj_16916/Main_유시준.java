import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int MAX=100000000;
	static int a[][]=new int[12][12];
	static int d[][]=new int[12][(1<<12)];
	static int n;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		String s1=br.readLine();
		String s2=br.readLine();
		bw.write(kmp(s1,s2)?"1":"0");
		bw.flush();
		bw.close();
		br.close();
	}
	static boolean kmp(String str,String ptr){
		int pi[]=getPi(ptr);
		int n=str.length();
		int m=ptr.length();
		int j=0;
		for(int i=0;i<n;i++) {
			while(j>0&&str.charAt(i)!=ptr.charAt(j)) {
				j=pi[j-1];
			}
			if(str.charAt(i)==ptr.charAt(j)) {
				if(j==m-1) {
					return true;
				}else {
					j++;
				}
			}
		}
		return false;
	}
	static int[] getPi(String ptr){ //접두사 접미사 체크해서 실패함수
		int m=ptr.length();
		int j=0;
		int pi[]=new int[m];
		for(int i=1;i<m;i++) {
			while(j>0&&ptr.charAt(i)!=ptr.charAt(j)) j=pi[j-1];
			if(ptr.charAt(i)==ptr.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
	}
}