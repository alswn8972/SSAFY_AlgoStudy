import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int MOD=1000000000;
    static int n,m;
    static Map<Integer,Integer> map1=new HashMap<>();
    static Map<Integer,Integer> map2=new HashMap<>();
    static List<Integer> list=new ArrayList<>();
    static boolean prime[]=new boolean[35001];
	public static void main(String[] args) throws IOException {
		primeNum();
		n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int a;
		for(int i=0;i<n;i++) {
			a=Integer.parseInt(st.nextToken());
			for(int j=0;j<list.size();j++) {
				int now=list.get(j);
				while(a%now==0) {
					if(!map1.containsKey(now)) map1.put(now, 1);
					else map1.put(now, map1.get(now)+1);
					a/=now;
				}
			}
			if(a!=1) {
				if(!map1.containsKey(a)) map1.put(a, 1);
				else map1.put(a, map1.get(a)+1);
			}
		}
		m=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int b;
		for(int i=0;i<m;i++) {
			b=Integer.parseInt(st.nextToken());
			for(int j=0;j<list.size();j++) {
				int now=list.get(j);
				while(b%now==0) {
					if(!map2.containsKey(now)) map2.put(now, 1);
					else map2.put(now, map2.get(now)+1);
					b/=now;
				}
			}
			if(b!=1) {
				if(!map2.containsKey(b)) map2.put(b, 1);
				else map2.put(b, map2.get(b)+1);
			}
		}
		boolean flag=false;
		long ans=1l;
		for(Map.Entry<Integer, Integer> entry:map1.entrySet()) {
			int key=entry.getKey();
			if(!map2.containsKey(key)) continue;
			int cnt=Math.min(map1.get(key), map2.get(key));
			for(int i=0;i<cnt;i++){
				ans*=key;
				if(ans>=MOD) flag=true;
				ans%=MOD;
			}
		}
		long k=ans;
		if(flag) {
			String str="";
			for(int i=0;i<9;i++) {
				int next=(int) (ans%10);
				ans/=10;
				str=Integer.toString(next)+str;
			}
			bw.write(str);
		}else {
			bw.write(ans+"");
		}
		bw.flush();
        bw.close();
        br.close();
	}
	static void primeNum() {
		for(int i=2;i<=35000;i++) {
			if(prime[i]) continue;
			list.add(i);
			for(int j=i*i;j<=35000;j+=i) {
				prime[j]=true;
			}
		}
	}
}
