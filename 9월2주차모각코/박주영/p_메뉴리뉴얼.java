import java.util.*;

public class p_메뉴리뉴얼 {
    List<String> list = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        for(int i = 0; i< orders.length; i++){
            char[] cur = orders[i].toCharArray();
            Arrays.sort(cur);

            for(int j = 0; j< cur.length-1; j++){
                for(int k = 0; k<course.length; k++){
                    combi(cur, j, 1, course[k], Character.toString(cur[j]));
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: list){
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        ArrayList<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1,o2)->(map.get(o2).compareTo(map.get(o1))));

        ArrayList<String> ansList = new ArrayList<>();
        for(int i = 0; i< course.length; i++){
            int max = 0;
            for(String k: keySetList){
                if(map.get(k) >= 2 && k.length() == course[i]){
                    if(map.get(k) >= max){
                        ansList.add(k);
                        max = map.get(k);
                    }
                }
            }
        }
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);
        return answer;
    }

    private void combi(char[] cur, int idx, int cnt, int n, String str) {
        if(cnt == n){
            list.add(str);
            return;
        }

        for(int i = idx+1; i<cur.length; i++){
            combi(cur, i, cnt+1, n, str+cur[i]);
        }
    }
}
