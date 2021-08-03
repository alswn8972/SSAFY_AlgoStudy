import java.util.Calendar;

public class Collection {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH) +1;
        int days[] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean isYun = ((year%4==0)&&(year%100!=0)||(year%400==0))?true:false;
        if(isYun){
            days[2]++;
        }
        System.out.println(days[month]+" days for "+year+"-"+month);
    }
}
