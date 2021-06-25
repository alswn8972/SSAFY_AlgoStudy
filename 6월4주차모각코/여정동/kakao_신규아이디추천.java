public class kakao_신규아이디추천 {	

	public static String solution(String new_id) {
		String answer = new_id.toLowerCase();
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");
		}
		StringBuilder sb;
		if(answer.length() > 0) {
			sb = new StringBuilder(answer);
			while(answer.charAt(0) == '.') {
				sb.deleteCharAt(0);
				answer = sb.toString();
				if(answer.length() == 0) break;
			}
		}
		if(answer.length() > 15) answer = answer.substring(0, 15);	

		if(answer.length() > 0) {
			sb = new StringBuilder(answer);
			while(answer.charAt(answer.length()-1) == '.') {
				sb.deleteCharAt(answer.length()-1);
				answer = sb.toString();
				if(answer.length() == 0) break;
			}
		}

		if(answer.length() == 0) answer = "a";
		if(answer.length() <= 2) {
			while(answer.length() < 3) {
				answer += answer.charAt(answer.length()-1);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(new_id));
	}
}
