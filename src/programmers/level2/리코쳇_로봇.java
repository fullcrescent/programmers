package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 리코쳇_로봇 {
    public static void main(String[] args){
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer = solution(board);
        System.out.println(answer);

        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer1 = solution1(board1);
        System.out.println(answer1);
    }

    public static int solution(String[] board) {
        int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] countArray = new int[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='R') {
                    queue.add(new int[] {i, j});
                    countArray[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] start = queue.poll();
            int count = countArray[start[0]][start[1]];

            for(int[] d : distance){
                int[] temp = start.clone();
                add(temp, d, 1);

                while(-1<temp[0] && temp[0]<board.length
                        && -1<temp[1] && temp[1]<board[0].length()
                        && board[temp[0]].charAt(temp[1])!='D'){
                    add(temp, d, 1);
                }

                add(temp, d, -1);

                if(countArray[temp[0]][temp[1]]==0) {
                    if(board[temp[0]].charAt(temp[1])=='G') return count;

                    countArray[temp[0]][temp[1]] = count + 1;
                    queue.add(new int[]{temp[0], temp[1]});
                }
            }
        }

        return -1;
    }

    private static void add(int[] value, int[] d, int mul) {
        value[0] += d[0]*mul;
        value[1] += d[1]*mul;
    }

    /*다른 사람의 풀이 참고*/
    public static int solution1(String[] board) {
        return new Board(board).calculateMoveCount();
    }
}

class Board{
    private static final int[][] d = {{1,0}, {0,-1}, {-1, 0}, {0, 1}};
    private final List<List<Token>> board;

    public Board(String[] board) {
        this(IntStream.range(0, board.length)
                .mapToObj(i -> IntStream.range(0, board[i].length())
                        .mapToObj(j -> new Token(Point.of(j, i),
                                TokenType.findType(Character.toString(board[i].charAt(j)))))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList()));
    }

    public Board(List<List<Token>> board) {
        this.board = board;
    }

    public int calculateMoveCount() {
        Token start = board
                .stream()
                .flatMap(Collection::stream)
                .filter(token -> token.getTokenType().isRobot())
                .findAny()
                .orElseThrow();

        Token end = board
                .stream()
                .flatMap(Collection::stream)
                .filter(token -> token.getTokenType().isGoal())
                .findAny()
                .orElseThrow();

        return calculateMoveCount(start, end);
    }

    private int calculateMoveCount(Token start, Token end) {
        int maxY = board.size();
        int maxX = board.get(0).size();

        boolean[][] visited = new boolean[maxY][maxX];

        Queue<Token> tokens = new LinkedList<>();
        tokens.add(start);
        int count = Integer.MAX_VALUE;
        visited[start.getPoint().getY()][start.getPoint().getX()] = true;

        while(!tokens.isEmpty()){
            Token current = tokens.poll();
            Point currentPoint = current.getPoint();

            if(current.equals(end)){
                count = Integer.min(count, current.getCount());
            }

            for(int i=0; i<4; i++){
                int dx = d[i][0];
                int dy = d[i][1];

                Point nextPoint = currentPoint;

                while (nextPoint.increasable(dx, dy, 0, 0, maxX-1, maxY-1)
                        && board.get(nextPoint.getY()+dy).get(nextPoint.getX()+dx).getTokenType().movable()){
                    nextPoint = nextPoint.increase(dx, dy);
                }

                if(!visited[nextPoint.getY()][nextPoint.getX()]){
                    Token token = board.get(nextPoint.getY()).get(nextPoint.getX());
                    token.updateCount(current.getCount()+1);
                    tokens.add(token);
                    visited[nextPoint.getY()][nextPoint.getX()] = true;
                }
            }
        }

        return Integer.MAX_VALUE == count ? -1 : count;
    }
}

class Token{
    private final Point point;
    private final TokenType tokenType;
    private int count;

    public Token(Point point, TokenType tokenType) {
        this.point = point;
        this.tokenType = tokenType;
        this.count = 0;
    }

    public Point getPoint() {
        return point;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public int getCount() {
        return count;
    }

    public void updateCount(int count){
        this.count = count;
    }
}

enum TokenType{
    ROBOT("R"),
    GOAL("G"),
    OBSTACLE("D"),
    EMPTY(".");

    private final String type;

    TokenType(String type) {
        this.type = type;
    }

    public static TokenType findType(String type) {
        return Arrays.stream(values())
                .filter(token -> token.type.equals(type))
                .findAny()
                .orElseThrow();
    }

    public boolean isRobot(){
        return ROBOT.equals(this);
    }

    public boolean isGoal(){
        return GOAL.equals(this);
    }

    public boolean isObstacle(){
        return OBSTACLE.equals(this);
    }

    public boolean isEmpty(){
        return EMPTY.equals(this);
    }

    public boolean movable(){
        return !isObstacle();
    }
}

class Point{
    private static final Point[][] CACHE = new Point[101][101];
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y){
        if(Objects.isNull(CACHE[y][x])){
            Point point = new Point(x, y);
            CACHE[y][x] = point;
        }

        return CACHE[y][x];
    }

    public Point increase(int x, int y){
        return Point.of(this.x + x, this.y + y);
    }

    public boolean increasable(int x, int y, int minX, int minY, int maxX, int maxY){
        return this.x + x >= minX && this.x + x <= maxX
                && this.y + y >= minY && this.y + y <= maxY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
