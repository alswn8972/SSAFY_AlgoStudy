package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N49_Group_Anagrams {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        char[] ch;
        String temp;
        for(int i=0;i<strs.length;i++){
         ch = strs[i].toCharArray();
         Arrays.sort(ch);
         temp = new String(ch);
         
         if(map.containsKey(temp)) {
        	 int x = map.get(temp);
        	 List<String> tlist = list.get(x);
        	 tlist.add(strs[i]);
         }else {
        	 List<String> newlist = new ArrayList<>();
        	 newlist.add(strs[i]);
        	 list.add(newlist);
        	 map.put(temp, list.size()-1);
         }
        }
        for(int i=0;i<list.size();i++) {
        	Collections.sort(list.get(i));
        }
        list.sort(new Comparator<List<String>>(){

			@Override
			public int compare(List<String> o1, List<String> o2) {
				
				return o1.size()-o2.size();
			}
        	
        });
        
        return list;
    }
}
