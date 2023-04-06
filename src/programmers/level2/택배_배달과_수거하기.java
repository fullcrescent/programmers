package programmers.level2;

public class 택배_배달과_수거하기 {
    public static void main(String[] args){
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        long answer = solution(cap, n, deliveries, pickups);
        System.out.println(answer);
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dIndex = findIndex(deliveries);
        int pIndex = findIndex(pickups);

        while(true){
            answer += 2L * (Math.max(dIndex, pIndex) + 1);
            dIndex = move(cap, dIndex, deliveries);
            pIndex = move(cap, pIndex, pickups);

            if(dIndex<0 && pIndex<0) return answer;
        }
    }

    private static int findIndex(int[] array) {
        int index = array.length-1;
        while(index>-1 && array[index]==0){index--;}
        return index;
    }

    private static int move(int cap, int index, int[] array) {
        while(index>-1 && cap>=array[index]){
            cap = cap-array[index];
            index--;
        }

        if(index>-1 && array[index]>0){
            array[index] -= cap;
        }

        return index;
    }
}
