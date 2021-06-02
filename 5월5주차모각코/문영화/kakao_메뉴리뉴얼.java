package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao_메뉴리뉴얼 {
	static Map<String, Integer> map;
	static boolean[] check;
	static char[] temp;
	public static void main(String[] args) {

		String[] order = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
//		solution(order,course);
		System.out.println(Arrays.toString(solution(order,course)));
	}
	
	 public static String[] solution(String[] orders, int[] course) {
	        List<String> answer = new ArrayList<>();
	        
	        
	        
	        for(int j=0;j<course.length;j++) {
	        	map = new HashMap<>();
	        	for(int i=0;i<orders.length;i++) {
		        	char[] temp=new char[orders[i].length()];
		        	for(int k=0;k<orders[i].length();k++) {
		        		temp[k]=orders[i].charAt(k);
		        	}
		        	Arrays.sort(temp);
		        	if(temp.length>=course[j])
		        		nCkV2(temp,course[j]);
		        }
	        	if(map.size()>0) {
	        		List<String> keySetList = new ArrayList<>(map.keySet());
			        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
					int max=map.get(keySetList.get(0));
					
					if(max>=2) {
						answer.add(keySetList.get(0));
						for(int k=1;k<keySetList.size();k++) {
							 if(max==map.get(keySetList.get(k))) {
								 answer.add(keySetList.get(k));
							 }else {
								 break;
							 }
							 
						}
					}
	        	}
	        	
        	}
	        
	        Collections.sort(answer);
	        String[] arr = answer.toArray(new String[answer.size()]);
	        return arr;
	    }

	 static void nCkV2(char[] arr,int k){
	        ArrayList<List<Integer>> ret = new ArrayList<>();
	        int n = arr.length;
	        for(int i=0;i<1<<n;i++){
	            int cnt = 0;
	            for(int j=0;j<n;j++){
	                if((i & 1<<j)>0) cnt++;
	            }
	            if(cnt==k){
	            	String key="";
	                for(int j=0;j<n;j++){
	                    if((i & 1<<j) > 0){
	                        key+=arr[j];
	                    }
	                }
	                if(map.containsKey(key)) {
	                 	  map.put(key,map.get(key)+1 );
	                   }else {
	                 	  map.put(key, 1);
	                   }
	            }
	        }
	        
	       
	    }

}
