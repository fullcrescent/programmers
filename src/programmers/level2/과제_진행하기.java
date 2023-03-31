package programmers.level2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 과제_진행하기 {
    public static void main(String[] args) throws ParseException {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[] answer = solution(plans);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[][] plans) throws ParseException {
        List<String> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Stack<String[]> stack  = new Stack<>();
        Arrays.sort(plans, Comparator.comparing(s -> s[1]));

        for(int i=0; i<plans.length-1; i++){
            long diff = Integer.parseInt(plans[i][2]) - (sdf.parse(plans[i+1][1]).getTime() - sdf.parse(plans[i][1]).getTime())/60/1000;

            if(diff>0){
                stack.add(new String[] {plans[i][0], String.valueOf(diff)});
            }else{
                list.add(plans[i][0]);

                while(!stack.isEmpty()){
                    String[] temp = stack.pop();
                    diff += Integer.parseInt(temp[1]);

                    if(diff<=0){
                        list.add(temp[0]);
                    }else{
                        stack.add(new String[] {temp[0], String.valueOf(diff)});
                        break;
                    }
                }
            }
        }

        stack.add(new String[] {plans[plans.length-1][0], ""});

        while(!stack.isEmpty()){
            list.add(stack.pop()[0]);
        }

        return list.toArray(new String[0]);
    }
}
