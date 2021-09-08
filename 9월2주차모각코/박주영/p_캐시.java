import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p_캐시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cacheSize = Integer.parseInt(br.readLine());
        String input = br.readLine().replaceAll("\"","");
        input = input.replaceAll(" ","");
        String[] cities = input.split(",");
        
        solution(cacheSize, cities);
        
    }

    static Queue<String> q = new LinkedList<>();
    private static int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return 5* cities.length;
        }
        int sum = 0;

        for(int i = 0; i< cities.length; i++){
            String city = cities[i].toLowerCase();
            if(check(city)){
                //cache hit
                sum+=1;
            }
            else{
                //cache miss
                if(q.size()>=cacheSize){
                    q.poll();
                }
                q.add(city);
                sum+=5;
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static boolean check(String city) {
        for(String str : q){
            if(str.equals(city)){
                q.remove(str);
                q.add(str);
                return true;
            }
        }
        return false;
    }
}
