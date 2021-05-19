package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


class user{
	String id;
	String re;
	
	public user(String id, String re) {
		this.id = id;
		this.re = re;
	}
	
}
public class kakao_오픈채팅방 {
	
	public static void main(String[] args) {
		String[] input= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(input)));
	}
	
	public static String[] solution(String[] record) {
	        String[] answer;
	        ArrayList<user> list = new ArrayList<>();
	        HashMap<String, String> users = new HashMap<String, String>();
	        
	        StringTokenizer st;
	        String type="";
	        String userid="";
	        String name="";
	        
	        for(int i=0;i<record.length;i++) {
	        	
	        	st = new StringTokenizer(record[i]);
	        	type = st.nextToken();
	        	userid = st.nextToken();
	        	if(!type.equals("Leave"))
	        		name = st.nextToken();
	        	
	        	if(!type.equals("Change")) {
	        		list.add(new user(userid,type));
	        	}
	        	if(!type.equals("Leave")) {
	        		users.put(userid, name);
	        	}
	        	
	        }
	        answer = new String[list.size()];
	        for(int i=0;i<list.size();i++) {
	        	user u= list.get(i);
	        	String t="";
	        	if(u.re.equals("Enter")) {
	        		t="님이 들어왔습니다.";
	        	}else {
	        		t="님이 나갔습니다.";
	        	}
	        	answer[i]="\""+users.get(u.id)+t+"\"";
	        }
	        return answer;
	}

}
