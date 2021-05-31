import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

// -_.~!@#$%^&*()=+[{]}:?,<>/
class Solution2 {
    public String solution(String new_id) {
        String answer1 = "";
        int size = new_id.length();
        char cur = ' ';
        // step1
        for(int i = 0; i<size; i++){
            cur = new_id.charAt(i);
            if(65<=cur && cur<=90)
                answer1 += (char)(cur+32);
            else
                answer1 += cur;
        }

        // step2
        size = answer1.length();
        String answer2 = "";
        for(int i = 0; i<size; i++){
            cur = answer1.charAt(i);
            if((97<=cur && cur<=122) || (48<=cur && cur<=57) || cur == 45 || cur == 46 || cur == 95)
                answer2 += cur;
            else
                continue;
        }

        // step3
        size = answer2.length();
        String answer3 = "";
        answer3 = answer2.replace("..",".");
        while(answer3.contains("..")){
            answer3 = answer3.replace("..",".");
        }

        // step4
        size = answer3.length();
        if(answer3.charAt(0) == '.' && size == 1) answer3 = "";
        else {
            if (answer3.charAt(0) == '.') {
                answer3 = answer3.substring(1, size);
            }
            size = answer3.length();
            if (answer3.charAt(size - 1) == '.') {
                answer3 = answer3.substring(0, size - 1);
            }
        }

        // step5
        if(answer3.length()==0){
            answer3 += "a";
        }

        // step6
        size = answer3.length();
        if(size>=16){
            answer3 = answer3.substring(0,15);
            size = answer3.length();
            if (answer3.charAt(size - 1) == '.') {
                answer3 = answer3.substring(0, size - 1);
            }
        }

        // step7
        size = answer3.length();
        if(answer3.length()<=2){
            char last = answer3.charAt(size-1);
            int repeat = 3-size;
            for(int i = 0; i<repeat; i++){
                answer3 += last;
            }
        }
        return answer3;
    }
}

public class programmers_신규아이디추천 {
    public static void main(String[] args) throws IOException {
        Solution2 s = new Solution2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();
        String answer = s.solution(new_id);
        System.out.println(answer);
    }
}