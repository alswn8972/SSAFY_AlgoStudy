import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class p_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();

        solution(msg);
    }

    private static <Map> int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        int str = 65;
        int num = 0;
        for(int i = 0; i<26; i++){
            map.put(Character.toString((char)str++), ++num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(msg.length()!=0){
            int idx = 0;
            StringBuffer w = new StringBuffer();
            w.append(msg.charAt(idx));
            while(true){
                if(map.containsKey(w.toString())){
                    if(msg.length()==w.toString().length()){
                        list.add(map.get(w.toString()));
                        msg="";
                        break;
                    }
                    w.append(msg.charAt(++idx));

                }
                else{
                    String remove = w.substring(0, w.length()-1);
                    list.add(map.get(remove));
                    msg = msg.substring(remove.length());
                    map.put(w.toString(),++num);
                    break;
                }
            }
        }

        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i: list){
            answer[idx++] = i;
        }
        return answer;
    }
}
