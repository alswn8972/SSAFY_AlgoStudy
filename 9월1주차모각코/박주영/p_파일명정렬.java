import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class p_파일명정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("\"","");

        String[] files = input.split(", ");

        solution(files);
    }
    private static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // head
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int res = head1.toLowerCase().compareTo(head2.toLowerCase());
                if(res == 0){
                    // num으로 비교
                    int num1 = createNum(o1, head1);
                    int num2 = createNum(o2, head2);
                    res = num1-num2;
                }
                return res;
            }
        });
        for(String s:files){
            System.out.println(s);
        }
        return files;
    }

//    private static String createHead(String str){
//        String head="";
//        for(int i = 0; i<str.length(); i++) {
//            char cur = str.charAt(i);
//            if (cur >= 97 && cur <= 122) {
//                // head이고 문자이면
//                head += cur;
//            }
//            else if(head.length()!=0) break;
//        }
//        return head;
//    }

    private static int createNum(String str, String head) {
       str = str.substring(head.length());
       String num = "";

       for(char c: str.toCharArray()){
           if(c>=48 && c<=57 && num.length()<5){
               num+=c;
           }
           else if(num.length()!=0)//숫자끝나면 -> tail
               break;
       }

       //System.out.println(num);
       return Integer.valueOf(num);
    }
}
