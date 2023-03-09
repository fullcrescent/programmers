package programmers.level2;

public class 덧칠하기 {
    public static void main(String[] args){
        int m = 4;
        int[] section = {2,3,6};
        int answer = solution(m, section);
        System.out.println(answer);
    }

    public static int solution(int m, int[] section) {
        int temp=section[0], index=0;
        int count = 0;

        while(true){
            while(index<section.length && section[index]<temp+m) {index++;}

            count++;

            if(index==section.length) return count;
            temp = section[index];
        }
    }
}
