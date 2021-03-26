import java.io.*;
import java.util.*;

public class Main_1726_윤경한 {
	static int map[][];
	static int N,M;
	static int Sx,Sy,Sd;
	static int Fx,Fy,Fd;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		Sx = Integer.parseInt(st.nextToken());
		Sy = Integer.parseInt(st.nextToken());
		Sd = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		Fx = Integer.parseInt(st.nextToken());
		Fy = Integer.parseInt(st.nextToken());
		Fd = Integer.parseInt(st.nextToken());
		
		

	}
}
