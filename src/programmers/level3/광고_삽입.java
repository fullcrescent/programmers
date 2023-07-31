package programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 광고_삽입 {
    public static void main(String[] args) {
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        String answer = solution(play_time, adv_time, logs);
        System.out.println(answer);

        String answer3 = solution3(play_time, adv_time, logs);
        System.out.println(answer3);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        List<ViewTime> viewTimeList = new ArrayList<>();

        for(String temp : logs) {
            String[] array = temp.split("-");

            viewTimeList.add(new ViewTime(new Time(array[0]), new Time(array[1])));
        }
        viewTimeList.sort(Comparator.comparingInt(i -> i.startTime.value));


        return "";
    }

    /*시간초과*/
    public static String solution3(String play_time, String adv_time, String[] logs) {
        List<ViewTime> viewTimeList = new ArrayList<>();

        for(String temp : logs) {
            String[] array = temp.split("-");

            viewTimeList.add(new ViewTime(new Time(array[0]), new Time(array[1])));
        }
        viewTimeList.sort(Comparator.comparingInt(i -> i.startTime.value));

        List<AdvTime>  advTimeList = new ArrayList<>();
        viewTimeList.forEach(i -> {
            advTimeList.add(new AdvTime(i.startTime.value, i.startTime.value+new Time(adv_time).value));

            int value = i.endTime.value-new Time(adv_time).value;
            if(value>=0){
                advTimeList.add(new AdvTime(value, i.endTime.value));
            }else {
                advTimeList.add(new AdvTime(0, i.endTime.value-value));
            }
        });

        for(AdvTime advTime : advTimeList){
            int start = advTime.start;
            int end = advTime.end;
            int sum = 0;

            for(ViewTime viewTime : viewTimeList){
                if(viewTime.startTime.value <=end && start<=viewTime.endTime.value){
                    sum += Math.min(viewTime.endTime.value, end) - Math.max(viewTime.startTime.value, start);
                }

                if(end<viewTime.startTime.value){
                    break;
                }
            }
            advTime.sum = sum;
        }

        AdvTime answer = advTimeList.stream().max((i1, i2) -> {
            if(i1.sum==i2.sum){
                return i2.start-i1.start;
            }
            return i1.sum-i2.sum;
        }).orElse(new AdvTime(0, 0));

        return convertTime(answer.start);
    }

    private static String convertTime(int temp) {
        return String.format("%02d:%02d:%02d", temp/3600, temp%3600/60, temp%60);
    }

    static class AdvTime{
        int start;
        int end;
        int sum;

        public AdvTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
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
        String time;
        int hour;
        int minute;
        int second;
        int value;

        public Time(String time) {
            this.time = time;
            String[] array = time.split(":");

            this.hour = Integer.parseInt(array[0]);
            this.minute = Integer.parseInt(array[1]);
            this.second = Integer.parseInt(array[2]);
            this.value = this.hour*3600 + this.minute*60 + this.second;
        }
    }
}
