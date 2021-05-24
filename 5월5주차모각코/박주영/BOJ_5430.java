import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(tmp.substring(1,tmp.length()-1),",");
            Deque<String> dq = new LinkedList<>();
            if(n!=0) {
                for (int i = 0; i < n; i++) {
                    dq.addLast(st.nextToken());
                }
            }
            else{
                if(p.contains("D")) sb.append("error").append("\n");
                else sb.append("[]").append("\n");
                continue;
            }

            boolean reverse = false;
            boolean err = false;
            a:for(int i = 0; i<p.length(); i++){
                if(p.charAt(i)=='R'){
                    reverse = !reverse;
                }
                else {
                    if(dq.isEmpty()){
                        err = true;
                        break a;
                    }

                    if(reverse){
                        dq.removeLast();
                    }
                    else{
                        dq.removeFirst();
                    }
                }
            }
            if(err){
                sb.append("error").append("\n");
            }
            else{
                sb.append("[");
                if(!dq.isEmpty()) {
                    if (reverse) {
                        while (!dq.isEmpty()) {
                            sb.append(dq.pollLast()).append(",");
                        }
                    } else {
                        while (!dq.isEmpty()) {
                            sb.append(dq.poll()).append(",");
                        }
                    }

                    sb.deleteCharAt(sb.lastIndexOf(","));
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
