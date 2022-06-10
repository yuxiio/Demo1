package Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.of(year,month,1);
        int week_d = 0;
        for(DayOfWeek week : DayOfWeek.values()){
            System.out.printf("%9s\t",week);
            week_d = date.getDayOfWeek().ordinal()+1;
        }
        System.out.print('\n');
        int []day_months = {29,31,28,31,30,31,30,31,31,30,31,30,31};
        int day_month = 0;

        if((year%4==0&&year%100!=0&&month==2) || (year%4==0&&year%400==0&&month==2))
            day_month = day_months[0];
        else day_month = day_months[month];

        int cnt = 0;

        for(int i = 0;i < week_d-1;i++){
            System.out.printf("%9s\t"," ");
            cnt++;
        }

        for(int i = 0;i < day_month;i++){
            System.out.printf("%9s\t",i+1);
            cnt++;
            if(cnt%7==0) System.out.print('\n');
        }
    }
}
