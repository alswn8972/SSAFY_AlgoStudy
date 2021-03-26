import java.io.*;
import java.util.*;

public class Main_2502 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int D = sc.nextInt();
		int K = sc.nextInt();
		
		int Aarr[] = new int[31];
		int Barr[] = new int[31];
		
		Aarr[1]=1; Aarr[2] =0;
		Aarr[3]=1;Aarr[4]=1;
		Aarr[5]=2;
		
		Barr[1]=0; Barr[2]=1;
		Barr[3]=1; Barr[4]=2;
		Barr[5]=3;
		
		
		
		for (int i = 6; i <=D; i++) {
			Aarr[i] = Aarr[i-1] + Aarr[i-2];
			Barr[i] = Barr[i-1] + Barr[i-2];
		}
		
		int a=1,b=1;
		
		aaa:while(Aarr[D]*a + Barr[D]*b != K )
		{
			int atemp = Aarr[D]*a;
			
			while(atemp + Barr[D]*b <= K)
			{
				if(atemp +  Barr[D]*b == K)
				{
					break aaa;
				}
				b+=1;
			}
			a+=1;
			b=0;
		}
		
		System.out.println(a);
		System.out.println(b);
	}

}
