import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_여정동{
	static int N, M;
	static Nation[] na;
	static int P, Q; 
	
	static int find(int i) {
		if(na[i].k == i) return i;

		return find(na[i].k);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		na = new Nation[N+1];
		for(int i = 1; i <= N; i++) {
			na[i] = new Nation(i,Integer.parseInt(br.readLine()));
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			int P_master = find(P);
			int Q_master = find(Q);
			switch (o) {
			case 1:
				if(na[P_master].allys < na[Q_master].allys) {
					na[P_master].allys += na[Q_master].allys;
					na[Q_master].allys = 0;
					na[P_master].army += na[Q_master].army;
					na[Q_master].k = P_master;
				}
				else {
					na[Q_master].allys += na[P_master].allys;
					na[P_master].allys = 0;
					na[Q_master].army += na[P_master].army;
					na[P_master].k = Q_master;
				}
				break;

			case 2:
				if(na[P_master].army < na[Q_master].army) {
					na[Q_master].army -= na[P_master].army;
					na[P_master].k = Q_master;
				}
				else if(na[P_master].army > na[Q_master].army) {
					na[P_master].army -= na[Q_master].army;
					na[Q_master].k = P_master;
				}
				else {
					na[P_master].army = 0;
					na[Q_master].army = 0;
					na[P_master].k = -1;
					na[Q_master].k = -1;
				}
				break;
			}
		}
		
		ArrayList<Integer> le = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(na[i].k == i) {
				le.add(na[i].army);
			}
		}
		Collections.sort(le);
		
		bw.write(le.size()+"\n");
		for(int i = 0 ; i < le.size(); i++) {
			bw.write(le.get(i)+" ");
		}
		
		bw.flush();
	}
}
class Nation{
	int k;
	int army;
	int allys = 0;
	Nation(int k, int army){
		this.k = k;
		this.army = army;
	}
}