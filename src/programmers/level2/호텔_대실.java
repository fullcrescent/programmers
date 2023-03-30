package programmers.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class 호텔_대실 {
    public static void main(String[] args) throws ParseException {
        String[][] book_time = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        int answer = solution(book_time);
        System.out.println(answer);
    }

    public static int solution(String[][] book_time) throws ParseException {
        List<Date> startList = new ArrayList<>();
        List<Date[]> intervalList = new ArrayList<>();
        long clearTime = 10 * 60 * 1000;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        for(String[] book : book_time){
            Date start = sdf.parse(book[0]);
            Date end = sdf.parse(book[1]);
            end.setTime(end.getTime()+clearTime);

            startList.add(start);
            intervalList.add(new Date[] {start, end});
        }

        int max = 0;

        for(Date start : startList){
            int count = 0;

            for(Date[] temp : intervalList){
                if((temp[0].before(start) || temp[0].equals(start)) && temp[1].after(start)) count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
