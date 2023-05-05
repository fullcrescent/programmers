package programmers.level2;

import java.util.Arrays;

public class 이모티콘_할인행사 {
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] answer = solution(users, emoticons);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int count = 0;
        for(int[] user : users){
            int sum = 0;
            for(int emoticon : emoticons){
                sum += (100-user[0])*emoticon/100;
            }

            if(user[1]<sum) count++;
        }

        System.out.println(count);
        return null;
    }
}
