package programers;

import java.util.HashMap;

public class kakao_뉴스_클러스터링 {
	
	static HashMap<String, Integer> str1map;
	static HashMap<String, Integer> str2map;
	public static void main(String[] args) {
//		String s ="aaa bb+S";
//		s=s.toUpperCase();
//		System.out.println(s.replaceAll("[^A-Z]", ""));
		
//		str1map= new HashMap<>();
//		splitstr2("FRANCE", str1map);
//		System.out.println(str1map);
//		System.out.println((int)'Z');
		System.out.println(solution("E=M*C^2","e=m*c^2"));
		
	}
	 public static int solution(String str1, String str2) {
	        int answer = 0;
	        str1map= new HashMap<>();
	        str2map= new HashMap<>();
	        str1 = str1.toUpperCase();
	        str2 = str2.toUpperCase();
	        
//	        str1 = str1.replaceAll("[^A-Z]", "");
//	        str2 = str2.replaceAll("[^A-Z]", "");
	        splitstr2(str1, str1map);
	        splitstr2(str2, str2map);
	        if(str1map.size()>=str2map.size()) {
	        	answer = jacard(str1map,str2map);
	        }else {
	        	answer = jacard(str2map,str1map);
	        }
	        return answer;
	  }
	 
	 public static int jacard(HashMap<String, Integer> map1,HashMap<String, Integer> map2) {
		 int union=0;
		 double inter=0;
		 if(map1.size()==0&&map1.size()==0) {
			 return 65536;
		 }else if(map1.size()==0||map1.size()==0){
			 return 0;
		 }
		 for(String key: map1.keySet()) {
			 if(map2.containsKey(key)) {
				 union+=Math.max(map1.get(key), map2.get(key));
				 inter+=Math.min(map1.get(key), map2.get(key));
			 }else {
				 union+=map1.get(key);
			 }
		 }
		 for(String key: map2.keySet()) {
			 if(map1.containsKey(key)) {
				 
			 }else {
				 union+=map2.get(key);
			 }
		 }
		 
		 double answer = (inter/union)*65536;
		 return (int)Math.floor(answer);
	 }
	 public static void splitstr2(String str, HashMap<String, Integer> map) {
		 
		 String temp="";
		 for(int i=0;i<str.length()-1;i++) {
			 temp=str.substring(i,i+2);
			 boolean flag=false;
			 for(int j=0;j<2;j++) {
				 if(temp.charAt(j)<65 || temp.charAt(j)>90)
					 flag=true;
			 }
			 if(flag) continue;
			 if(map.containsKey(temp)) {
				 map.put(temp, map.get(temp)+1);
			 }else {
				 map.put(temp, 1);
			 }
			 
		 }
	 }
}
