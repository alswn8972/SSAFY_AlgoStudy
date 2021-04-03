import java.util.*;
import java.io.*;
public class Main_1484 {
	public static void main(String[] args) {
		StringBuilder sb= new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		int x=1,y=1;
		boolean flag = false;
		while(y<=x && x <= 100000)
		{
			int temp = x*x - y*y;
			
			if(temp < G) x++;
			
			else if(temp == G) {
				flag = true;
				sb.append(x+"\n");
				x++;
			}
			else
				y++;
		}
		
		if(!flag) System.out.println(-1);
		
		else  System.out.println(sb.toString());
		
	}
}
