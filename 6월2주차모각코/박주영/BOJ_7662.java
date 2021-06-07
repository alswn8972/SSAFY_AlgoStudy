import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            TreeMap<Long, Long> map = new TreeMap<>();
            for(int i = 0; i<k; i++) {
                st = new StringTokenizer(br.readLine()," ");
                String oper = st.nextToken();
                long n = Long.parseLong(st.nextToken());

                if(oper.equals("I")){
                    if(map.containsKey(n)){
                        map.put(n, map.get(n)+1);
                    }
                    else
                        map.put(n, 1L);
                }
                else if(oper.equals("D")){
                    if(map.isEmpty())continue;
                    if(n==-1){
                        // 최소값 삭제
                        long min = map.firstKey();
                        long minValue = map.get(min);
                        if(minValue-1 == 0)
                            map.remove(min);
                        else
                            map.put(min, minValue-1);
                    }
                    else{
                        long max = map.lastKey();
                        long maxValue = map.get(max);
                        if(maxValue-1 == 0)
                            map.remove(max);
                        else
                            map.put(max, maxValue-1);
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else
                sb.append(map.lastKey()+" "+map.firstKey()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
