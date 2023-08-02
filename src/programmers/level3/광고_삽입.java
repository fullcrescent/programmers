package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 광고_삽입 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String answer = solution(play_time, adv_time, logs);
        System.out.println(answer);

        String answer3 = solution3(play_time, adv_time, logs);
        System.out.println(answer3);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int total = convertInt(play_time);
        int[] viewCountArray = new int[total];

        for(String log : logs){
            String[] array = log.split("-");
            int start = convertInt(array[0]);
            int end = convertInt(array[1]);

            for(int i=start; i<end; i++){
                viewCountArray[i] += 1;
            }
        }

        String answer = "00:00:00";

        int advTime = convertInt(adv_time);
        long sum = Arrays.stream(viewCountArray, 0, advTime).sum();
        long max = sum;

        for(int i=1; i<total-advTime; i++){
            sum -= viewCountArray[i];
            sum += viewCountArray[i+advTime];

            if(max<sum){
                max = sum;
                answer = convertTime(i+1);
            }
        }

        return answer;
    }

    private static int convertInt(String time) {
        String[] array = time.split(":");
        int hour = Integer.parseInt(array[0]);
        int minute = Integer.parseInt(array[1]);
        int second = Integer.parseInt(array[2]);

        return hour*3600 + minute*60 + second;
    }

    private static String convertTime(int temp) {
        return String.format("%02d:%02d:%02d", temp/3600, temp%3600/60, temp%60);
    }

    /*시간초과*/
    public static String solution3(String play_time, String adv_time, String[] logs) {
        List<ViewTime3> viewTimeList = new ArrayList<>();

        for(String temp : logs) {
            String[] array = temp.split("-");

            viewTimeList.add(new ViewTime3(new Time3(array[0]), new Time3(array[1])));
        }
        viewTimeList.sort(Comparator.comparingInt(i -> i.startTime.value));

        List<AdvTime3>  advTimeList = new ArrayList<>();
        viewTimeList.forEach(i -> {
            advTimeList.add(new AdvTime3(i.startTime.value, i.startTime.value+new Time3(adv_time).value));

            int value = i.endTime.value-new Time3(adv_time).value;
            if(value>=0){
                advTimeList.add(new AdvTime3(value, i.endTime.value));
            }else {
                advTimeList.add(new AdvTime3(0, i.endTime.value-value));
            }
        });

        for(AdvTime3 advTime : advTimeList){
            int start = advTime.start;
            int end = advTime.end;
            int sum = 0;

            for(ViewTime3 viewTime : viewTimeList){
                if(viewTime.startTime.value <=end && start<=viewTime.endTime.value){
                    sum += Math.min(viewTime.endTime.value, end) - Math.max(viewTime.startTime.value, start);
                }

                if(end<viewTime.startTime.value){
                    break;
                }
            }
            advTime.sum = sum;
        }

        AdvTime3 answer = advTimeList.stream().max((i1, i2) -> {
            if(i1.sum==i2.sum){
                return i2.start-i1.start;
            }
            return i1.sum-i2.sum;
        }).orElse(new AdvTime3(0, 0));

        return convertTime3(answer.start);
    }

    private static String convertTime3(int temp) {
        return String.format("%02d:%02d:%02d", temp/3600, temp%3600/60, temp%60);
    }

    static class AdvTime3 {
        int start;
        int end;
        int sum;

        public AdvTime3(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class ViewTime3 {
        Time3 startTime;
        Time3 endTime;

        public ViewTime3(Time3 startTime, Time3 endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Time3 {
        String time;
        int hour;
        int minute;
        int second;
        int value;

        public Time3(String time) {
            this.time = time;
            String[] array = time.split(":");

            this.hour = Integer.parseInt(array[0]);
            this.minute = Integer.parseInt(array[1]);
            this.second = Integer.parseInt(array[2]);
            this.value = this.hour*3600 + this.minute*60 + this.second;
        }
    }
}
