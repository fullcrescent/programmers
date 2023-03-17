package programmers.level2;

public class 덧칠하기 {
    public static void main(String[] args){
        int m = 4;
        int[] section = {2,3,6};
        int answer = solution(m, section);
        System.out.println(answer);

        int m1= 4;
        int[] section1 = {2,3,6};
        int answer1 = solution1(m1, section1);
        System.out.println(answer1);
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

    /*다른 사람의 풀이 참고*/
    public static int solution1(int m, int[] section) {
        int temp = section[0];
        int count = 1;

        for(int i=1; i<section.length; i++){
            if(temp+m-1<section[i]){
                count++;
                temp = section[i];
            }
        }

        return count;
    }
}
