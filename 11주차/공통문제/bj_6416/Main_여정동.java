import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main_6416 {
	public static void main(String[] args) throws IOException {
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set;
		int[] inEdge;
		int case_num = 0;
		int root_count;
		boolean flag = false;
		int edge;

		while(true) {
			set = new HashSet<>();
			inEdge = new int[1001];
			root_count = 0;
			case_num++;
			flag = false;
			edge = 0;

			while(true) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				if(from==0 && to==0) 
					break;
				else if(from == -1 && to == -1) return;
				set.add(from);
				set.add(to);
				++inEdge[to];
				++edge;
			}
			if(set.size()<1) {
				System.out.println("Case "+ case_num +" is a tree.");
				continue;
			}

			Iterator it = set.iterator();
			
			while(it.hasNext()) {
				int num = (int) it.next();
				
				if(inEdge[num]==0) 
					root_count++;
				else if(inEdge[num] > 1) {
					flag = true;
					break;
				}
			}

			if(flag || root_count > 1 || set.size()-edge != 1) {
				System.out.println("Case "+ case_num +" is not a tree.");
				continue;
			}
			else
				System.out.println("Case "+ case_num +" is a tree.");
		}
	}
}