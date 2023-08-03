package programmers.level3;

public class 양과_늑대 {
    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        int answer = solution(info, edges);
        System.out.println(answer);
    }

    public static int solution(int[] info, int[][] edges) {
        Node root = new Node(0);

        for(int[] edge : edges){

        }

        return 0;
    }

    static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
