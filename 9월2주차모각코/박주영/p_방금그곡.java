import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_방금그곡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String m = br.readLine();
        String ms = br.readLine();
        String mss[] = ms.split("\"");
        ArrayList<String> list = new ArrayList<>();
        for(String s: mss){
            if(s.equals("")||s.equals(", "))continue;
            list.add(s);
        }
        String[] musicinfos = new String[list.size()];
        int idx = 0;
        for(String s: list){
            musicinfos[idx++] = s;
        }
        solution(m, musicinfos);
    }
    private static String solution(String m, String[] musicinfos) {
        int maxPlayTime = -1;
        String answer = "";

        // 멜로디에 들어있는 # 붙은 음 치환
        m = changeMelody(m);

        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");
            String title = info[2];
            // 악보 정보에 들어있는 # 붙은 음 치환
            String melodyInfo = changeMelody(info[3]);

            String[] timeInfo = info[0].split(":");
            // 시작 시간 분단위로 변환
            int start = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);
            int end = 0;

            timeInfo = info[1].split(":");
            // 끝난 시간 분단위로 변환
            end = Integer.valueOf(timeInfo[0]) * 60 + Integer.valueOf(timeInfo[1]);

            // 지속 시간 구함
            int play = end - start;

            // 음악의 길이보다 재생 지속 시간이 길 때
            if (play > melodyInfo.length()) {
                StringBuilder newMelody = new StringBuilder();

                // 나눈 몫 만큼 악보 처음부터 반복
                for (int i = 0; i < play / melodyInfo.length(); i++)
                    newMelody.append(melodyInfo);

                // 나머지만큼 악보에서 잘라서 붙임
                newMelody.append(melodyInfo.substring(0, play % melodyInfo.length()));
                melodyInfo = newMelody.toString();
            } else {
                // 재생 지속 시간 만큼만 재생
                melodyInfo = melodyInfo.substring(0, play);
            }

            // 조건이 일치하는 음악이 여러개면
            // 재생된 시간이 제일 긴 음악 제목을 반환해야 하기 때문에
            // 조건에 멜로디 포함뿐만 아니라, 재생된 시간가지 비교
            if (melodyInfo.contains(m) && play > maxPlayTime) {
                answer = title;
                maxPlayTime = play;
            }

        }

        return maxPlayTime != -1 ? answer : "(None)";
    }
    private static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");
        return newMelody;
    }


//    private static String solution(String m, String[] musicinfos) {
//        String[] ms = mkMelody(m);
//        HashMap<String, String[]> musics = mkMap(musicinfos);
//        HashMap<String, Integer> answer = new HashMap<>(); //title, 일치개수
//        for(String key: musics.keySet()){
//            String[] getM = musics.get(key);
//            int cnt = 0;
//
//            for(int i = 0; i< getM.length; i++){
//                if(cnt == 0 && ms[cnt]==getM[i]){
//                    cnt++;
//                }
//                else if(cnt!=0)break;
//            }
//            answer.put(key, cnt);
//        }
//        String title = "(None)";
//        int max = -1;
//        for(String key: answer.keySet()){
//            if(answer.get(key)>max){
//                max = answer.get(key);
//                title = key;
//            }
//        }
//
//        System.out.println(title);
//        return title;
//    }

//    private static HashMap<String, String[]> mkMap(String[] musicinfos) {
//        HashMap<String, String[]> res = new HashMap<>();
//        for(int i = 0; i<musicinfos.length; i++){
//            String[] cur = musicinfos[i].split(",");
//            int startH = Integer.parseInt(cur[0].split(":")[0]);
//            int startM = Integer.parseInt(cur[0].split(":")[1]);
//            int endH = Integer.parseInt(cur[1].split(":")[0]);
//            int endM = Integer.parseInt(cur[1].split(":")[1]);
//            int sToE = (endH*60+endM)-(startH*60+startM);
//            String[] tmp = mkMelody(cur[3]);
//            String[] real = new String[sToE];
//            for(int j = 0; j<sToE; j++){
//                real[j] = tmp[j%tmp.length];
//            }
//            res.put(cur[2], real); //title, melody
//        }
//
//        return res;
//    }
//
//    private static String[] mkMelody(String m) {
//        String msize = m.replaceAll("#","");
//        String[] arr = new String[msize.length()];
//        int idx = 0;
//        StringBuilder tmp = new StringBuilder();
//        for(int i = 0; i<m.length(); i++){
//            tmp.append(m.charAt(i));
//            if(i+1<m.length() && m.charAt(i+1)=='#'){
//                tmp.append(m.charAt(i+1));
//                i++;
//            }
//            arr[idx++] = tmp.toString();
//            tmp.setLength(0);
//        }
//
//        return arr;
//    }
}
