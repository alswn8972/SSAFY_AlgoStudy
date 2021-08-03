import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_SSAFY알고대회_StarDraft승부예측하기 {
    static int[] count,order;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            order = new int[32];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i<32; i++){
                order[i] = Integer.parseInt(st.nextToken());
            }

            // 리그전
            count = new int[32];
            list = new ArrayList<>();
            for(int i = 0; i<32; i+=4){
                count[fight(i,i+1)]++;
                count[fight(i,i+2)]++;
                count[fight(i,i+3)]++;
                count[fight(i+1,i+2)]++;
                count[fight(i+1,i+3)]++;
                count[fight(i+2,i+3)]++;
                TreeMap<Integer, Integer>map = new TreeMap<>();
                for(int j = 0; j<4; j++){
                    map.put(i+j,count[i+j]);
                }
                List<Integer> keySetList = new ArrayList<>(map.keySet());
                Collections.sort(keySetList, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o2).compareTo(map.get(o1));
                    }
                });
                int[] tmp = new int[4];
                int k = 0;
                for(int key:keySetList){
                    tmp[k++] = key;
                }
                list.add(tmp[0]);
                list.add(tmp[1]);
            }

            // 토너먼트
            int tourna = 8;
            ArrayList<Integer> res = new ArrayList<>();
            while(tourna>0) {
                res = tournament(0,list.size()-1, new ArrayList<>());
                list = res;
                tourna /=2;
            }
            System.out.println("#"+tc+" "+res.get(0));
        }
    }

    private static ArrayList<Integer> tournament(int a, int b,ArrayList<Integer> winner) {
        if(a>b){
            return winner;
        }
        int win = fight(list.get(a), list.get(b));
        winner.add(win);
        tournament(a+1, b-1, winner);
        return winner;
    }

    private static int fight(int a, int b) {
        if(Math.abs(order[a]-order[b])<=1){
            return order[a]<=order[b]?a:b;
        }
        else{
            return order[a]>order[b]?a:b;
        }
    }

}
