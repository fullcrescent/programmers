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
        int[] discount = new int[emoticons.length];
        Arrays.fill(discount, 10);

        double max = Math.pow(4, emoticons.length);
        int[][] answer = new int[(int) max][2];

        for(int index=0; index<max; index++){
            int count = 0;
            int sum = 0;

            for(int[] user : users){
                int temp = 0;

                for(int j=0; j<discount.length; j++){
                    if(discount[j]<user[0]) continue;

                    temp += emoticons[j] * (100-discount[j])/100;
                }

                if(user[1]<=temp){
                    count++;
                }else{
                    sum += temp;
                }
            }

            answer[index] = new int[] {count, sum};

            add(discount);
        }

        Arrays.sort(answer, (i1, i2) -> i1[0]==i2[0] ? i2[1]-i1[1] : i2[0]-i1[0]);

        return answer[0];
    }

    private static void add(int[] array) {
        for(int i=0; i< array.length; i++){
            if(array[i]==40){
                array[i] = 10;
            }else{
                array[i] += 10;
                return;
            }
        }
    }
}
