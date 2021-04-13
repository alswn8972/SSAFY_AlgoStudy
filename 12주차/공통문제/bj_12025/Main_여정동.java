import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_여정동{
	static long k, p, count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		char[] ch = s.toCharArray();
		k = Long.parseLong(br.readLine());

		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == '6' || ch[i] == '7' || ch[i] == '1' || ch[i] == '2') {
				count++;
				if(ch[i] == '6') {
					ch[i] = '1';
				}
				else if(ch[i] == '7') {
					ch[i] = '2';
				}
			}
		}

		if(Math.pow(2,count) < k || k < 1) {
			System.out.println(-1);
			return;
		}
		k--;

		int ind = 0;
		
		for(int i = ch.length-1; i > -1 ; i--) {	
			if(ch[i] == '1' || ch[i] == '2') {
				if((k & 1<<ind) != 0) {
					if(ch[i] == '1') {
						ch[i] = '6';
					}
					else ch[i] = '7';
				}
				ind++;
			}
			if(ind > k) break;
		}


		s = String.valueOf(ch);

		System.out.println(s);
	}
}
