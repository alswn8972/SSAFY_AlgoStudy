package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class kakao_압축 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
	}
	
	public static Integer[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		boolean[] strb = new boolean[msg.length()];
		for(int i=1;i<=26;i++) {
			map.put(String.valueOf((char)(64+i)),i);
		}
		int value=27;
		for(int i=0;i<msg.length();i++) {
			String s =String.valueOf(msg.charAt(i));
			if(i==msg.length()-1&&!strb[msg.length()-1]&&map.containsKey(s)) {
				list.add(map.get(s));
			}else if(map.containsKey(s)) {
				strb[i]=true;
				for(int j=i+1;j<msg.length();j++) {
					s+=msg.charAt(j);
					strb[j]=true;
					if(!map.containsKey(s)) {
						map.put(s, value++);
						String str = s.substring(0,s.length()-1);
						strb[j]=false;
						list.add(map.get(str));
						i+=j-i-1;
						
						break;
					}else if(j==msg.length()-1&&map.containsKey(s)) {
						list.add(map.get(s));
						i+=j-i-1;
						break;
					}
				}
				
			}
		}
		Integer[] result = list.toArray(new Integer[] {0});
		return result;
    }

}
