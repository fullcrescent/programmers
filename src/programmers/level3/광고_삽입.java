package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 광고_삽입 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String answer = solution(play_time, adv_time, logs);
        System.out.println(answer);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        List<ViewTime> list = new ArrayList<>();

        for(String temp : logs) {
            String[] array = temp.split("-");

            list.add(new ViewTime(new Time(array[0]), new Time(array[1])));
        }

        list.sort((i1, i2) -> {
            if(i1.endTime.time==i2.endTime.time){
                return i1.startTime.time-i2.startTime.time;
            }

            return i1.endTime.time-i2.endTime.time;
        });

        for(ViewTime temp : list){
            int start = temp.startTime.time;
            int end = start + new Time(adv_time).time;
            int sum = 0;

            for(ViewTime viewTime : list){
                if(viewTime.startTime.time<=end && start<=viewTime.endTime.time){
                    sum += Math.max(viewTime.endTime.time, end) - Math.max(viewTime.startTime.time, start);
                }

                if(end<viewTime.startTime.time){
                    break;
                }
            }

            System.out.println(sum);
        }

        return null;
    }

    static class ViewTime{
        Time startTime;
        Time endTime;

        public ViewTime(Time startTime, Time endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Time{
        int hour;
        int minute;
        int second;
        int time;

        public Time(String time) {
            String[] array = time.split(":");

            this.hour = Integer.valueOf(array[0]);
            this.minute = Integer.valueOf(array[1]);
            this.second = Integer.valueOf(array[2]);
            this.time = this.hour*3600 + this.minute*60 + this.second;
        }
    }
}
