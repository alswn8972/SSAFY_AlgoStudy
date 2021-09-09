package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class N직업군추천하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] lan = {"PYTHON", "C++", "SQL"};
		String[] lan2 = {"JAVA", "JAVASCRIPT"};
		int[] pre = {7,5};
		System.out.println(solution(table,lan2,pre));

	}
	
	public static String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, Integer> map =  new HashMap<>();
        int total;
        for(String str : table) {
        	StringTokenizer st = new StringTokenizer(str);
        	String name = st.nextToken();
        	int score=5;
        	total=0;
        	while(st.hasMoreTokens()) {
        		String lan=st.nextToken();
        		for(int i=0;i<languages.length;i++) {
        			if(lan.equals(languages[i])) {
        				total+=(score*preference[i]);
        				break;
        			}
        		}
        		score--;
        	}
        	map.put(name, total);
        }
        int max=0;
        List<String> s = null;
        for(String key: map.keySet()) {
        	if(max<map.get(key)) {
        		s= new ArrayList<>();
        		s.add(key);
        		max=map.get(key);
        	}else if(max==map.get(key)) {
        		s.add(key);
        	}
        }
        if(s.size()>1) {
        	Collections.sort(s);
        }
        return s.get(0);
    }

}
