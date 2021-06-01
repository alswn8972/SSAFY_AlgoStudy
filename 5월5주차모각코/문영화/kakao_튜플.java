package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class numnode implements Comparable<numnode>{
	String[] arr;

	public numnode(String[] arr) {
		this.arr = arr;
	}

	@Override
	public int compareTo(numnode o) {
		return this.arr.length-o.arr.length;
	}

	@Override
	public String toString() {
		return "numnode [arr=" + Arrays.toString(arr) + "]";
	}
	
	
	
}
public class kakao_튜플 {
	
	public static Map<String,Boolean> map; 
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		System.out.println(Arrays.toString(solution(s)));
		
	}
	public static Integer[] solution(String s) {
        Integer[] answer = {};
        map = new HashMap<>(); 
        List<Integer> ans = new ArrayList<>();
        List<numnode> list = new ArrayList<>();
        s=s.substring(1,s.length()-1);
        String[] temp = s.split("}");
        
        numnode nn;
        for(String str:temp) {
        	nn= new numnode(changeArr(str));
        	list.add(nn);
        }
        Collections.sort(list);
        
        for(numnode n:list) {
        	temp= n.arr;
        	for(String d:temp) {
        		if(!map.containsKey(d)) {
        			ans.add(Integer.parseInt(d));
        			map.put(d, true);
        		}
        	}
        }
        answer = ans.toArray(new Integer[ans.size()]);
        return answer;
    }
	public static String[] changeArr(String s) {
		String temp = "";
		if(s.charAt(0)==',') {
			temp = s.substring(2,s.length());
			
		}else if (s.charAt(0)=='{') {
			temp = s.substring(1,s.length());
		}
		String[] arr = temp.split(",");
		return arr;
		
	}

}
