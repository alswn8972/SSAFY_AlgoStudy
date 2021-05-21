package programers;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_cache {
	
	public static void main(String[] args) {
		String[] city = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(3, city));
	}
	public static int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        if(cacheSize==0) 
	        	return cities.length*5;
	        
	        Queue<String> queue =new LinkedList<>();
	        for(int i=0;i<cities.length;i++) {
	        	boolean check = ((LinkedList<String>)queue).removeFirstOccurrence(cities[i].toUpperCase());
	        	queue.add(cities[i]);
	        	answer++;
	        	if(!check) {
	        		answer+=4;
	        		if(queue.size()>cacheSize) {
	        			queue.poll();
	        		}
	        	}
	        }
	        
	        
	        return answer;
	}
	

}
