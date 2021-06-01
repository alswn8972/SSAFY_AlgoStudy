class kakao_단체사진찍기 {
    
    static Option[] option;
    static int count = 0;
    static boolean[] iv = new boolean[8];
    static int[] arr = new int[8];
    
    public void dfs(int depth){
        if(depth == 8){
            for(int i = 0; i < option.length; i++){
                if(!isCorrect(option[i])) return;
            }
            count++;
        }
        
        else { 
            for(int i = 0; i < 8; i++){
                if(!iv[i]){
                    iv[i] = true;
                    arr[depth] = i;
                    dfs(depth+1);
                    iv[i] = false;
                }
            }
        }
    }
    
    public boolean isCorrect(Option option){
        int ind0 = 0;
        int ind1 = 0;
        for(int i = 0; i < 8; i++){
            if(arr[i] == option.a) ind0 = i;
            if(arr[i] == option.b) ind1 = i;
        }
        
        int dist = Math.abs(ind0-ind1) - 1;
        
        if(option.opt == '='){
            if(dist == option.range) {
                return true;
            }
            else return false;
        }
        else if(option.opt == '<'){
            if(dist < option.range) {
                return true;
            }
            else return false;
        }
        else if(option.opt == '>'){
            if(dist > option.range) {
                return true;
            }
            else return false;
        }
        
        return false;
    }
    
    public int toNum(char c){
        if(c == 'A') return 0;
        else if(c == 'C') return 1;
        else if(c == 'F') return 2;
        else if(c == 'J') return 3;
        else if(c == 'M') return 4;
        else if(c == 'N') return 5;
        else if(c == 'R') return 6;
        else if(c == 'T') return 7;
        else return -1;
    }
    
    public Option decoder(String data){
        int a = toNum(data.charAt(0));
        int b = toNum(data.charAt(2));                        
        char opt = data.charAt(3);
        int range = data.charAt(4) - '0';        
        return new Option(a,b,opt,range);
    }
    
    public int solution(int n, String[] data) {     
        
        option = new Option[n];
        count = 0;
        
        for(int i = 0; i < n; i++){
            option[i] = decoder(data[i]);
        }
        dfs(0);
        int answer = count;
        return answer;
    }
    
    static class Option{
        int a;
        int b;
        char opt;
        int range;
        
        Option(int a, int b, char opt, int range){
            this.a = a;
            this.b = b;
            this.opt = opt;
            this.range = range;
        }   
    }
}