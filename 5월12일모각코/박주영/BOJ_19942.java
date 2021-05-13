import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19942 {
    static class Food{
        int protein,fat,carbo,vitamin;
        int price;

        public Food(int protein, int fat, int carbo, int vitamin, int price) {
            this.protein = protein;
            this.fat = fat;
            this.carbo = carbo;
            this.vitamin = vitamin;
            this.price = price;
        }
    }

    static Food std;
    static Food[] foods;
    static int N;
    static ArrayList<Integer> minList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        foods = new Food[N+1];

        st = new StringTokenizer(br.readLine()," ");

        int s_protein = Integer.parseInt(st.nextToken());
        int s_fat = Integer.parseInt(st.nextToken());
        int s_carbo = Integer.parseInt(st.nextToken());
        int s_vitamin = Integer.parseInt(st.nextToken());
        std = new Food(s_protein,s_fat,s_carbo,s_vitamin,Integer.MAX_VALUE);
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int protein = Integer.parseInt(st.nextToken());
            int fat = Integer.parseInt(st.nextToken());
            int carbo = Integer.parseInt(st.nextToken());
            int vitamin = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            foods[i] = new Food(protein, fat, carbo, vitamin, price);
        }

        res = new int[N+1];
        Arrays.fill(res, -1);
        minList = new ArrayList<>();
        powerset(1, new Food(0,0,0,0,0));

        if(std.price == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(std.price);

        for(int item: minList){
            System.out.print(item+" ");
        }
    }

    static int res[];
    private static void powerset(int cnt, Food sum) {
        if(isOk(sum)){
            if(sum.price<std.price){
                std.price = sum.price;
                minList.clear();
                for(int i = 1; i<=N; i++){
                    if(res[i] == -1)continue;
                    else if(res[i] == 1)minList.add(i);
                }
            }
        }
        if(cnt == N+1){
            if(isOk(sum)){
                if(sum.price<std.price){
                    std.price = sum.price;
                    minList.clear();
                    for(int i = 1; i<=N; i++){
                        if(res[i] == -1)continue;
                        else if(res[i] == 1)minList.add(i);
                    }
                }
            }
            else{
                sum.price = 0;
            }
            return;
        }

        Food select = new Food(sum.protein+foods[cnt].protein,
                sum.fat+foods[cnt].fat,
                sum.carbo+foods[cnt].carbo,
                sum.vitamin+foods[cnt].vitamin,
                sum.price+foods[cnt].price);
        res[cnt] = 1;
        powerset(cnt+1, select);

        res[cnt] = -1;
        powerset(cnt+1, sum);

    }

    private static boolean isOk(Food food){
        return (food.protein>= std.protein) && (food.fat>=std.fat) && (food.carbo>= std.carbo) && (food.vitamin>=std.vitamin);
    }
}
