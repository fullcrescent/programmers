package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 광물_캐기 {
    public static void main(String[] args){
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer = solution(picks, minerals);
        System.out.println(answer);

        int[] picks1 = {1, 3, 2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer1 = solution1(picks1, minerals1);
        System.out.println(answer1);

        int[] picks2 = {1, 3, 2};
        String[] minerals2 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer2 = solution2(picks2, minerals2);
        System.out.println(answer2);
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int max = Math.min(Arrays.stream(picks).sum()*5, minerals.length);
        List<int[]> list = new ArrayList<>();
        int[] temp = new int[3];

        for(int i=0; i<max; i++){
            if(minerals[i].equals("diamond")){
                temp[0] += 1;
                temp[1] += 5;
                temp[2] += 25;
            }else if(minerals[i].equals("iron")){
                temp[0] += 1;
                temp[1] += 1;
                temp[2] += 5;
            }else {
                temp[0] += 1;
                temp[1] += 1;
                temp[2] += 1;
            }

            if((i+1)%5==0 || i==max-1){
                list.add(temp);
                temp = new int[3];
            }
        }

        list.sort((i1, i2) -> -Integer.compare(i1[2], i2[2]));

        for(int[] value : list){
            if(picks[0]!=0){
                answer += value[0];
                picks[0] -= 1;
            }else if(picks[1]!=0){
                answer += value[1];
                picks[1] -= 1;
            }else{
                answer += value[2];
            }
        }

        return answer;
    }

    /*다른 사람의 풀이 참고*/
    private static int solution1(int[] picks, String[] minerals) {
        return IntStream.iterate(0, i -> i<Math.min(Arrays.stream(picks).sum()*5, minerals.length), i -> i+5)
                .mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i+5, minerals.length)))
                        .mapToInt(s -> s.equals("diamond") ? 25 : s.equals("iron") ? 5 : 1).toArray())
                .sorted((a, b) -> Arrays.stream(b).sum()-Arrays.stream(a).sum())
                .mapToInt(arr -> {
                    int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
                    return Arrays.stream(arr).map(i -> Math.max(i/n, 1)).sum();
                })
                .sum();
    }

    private static int solution2(int[] picks, String[] minerals) {
//        return Minerals.of(minerals).digInMinFatigue(Picks.of(picks));
        return 0;
    }
}

class Minerals{
    private final List<Mineral> minerals;

    public Minerals(List<Mineral> minerals) {
        this.minerals = minerals;
    }

    public static Minerals of(String[] minerals){
        return Arrays
                .stream(minerals)
                .map(MineralType::findType)
                .map(Mineral::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Minerals::new));
    }


}

class Mineral{
    private static final Map<MineralType, Function<Pick, Integer>> DIGGING = Map
            .of(
                    MineralType.DIAMOND, Pick::digDIAMOND
                    ,MineralType.IRON, Pick::digIRON
                    ,MineralType.STONE, Pick::digStone
            );
    private final MineralType mineralType;

    public Mineral(MineralType mineralType) {
        this.mineralType = mineralType;
    }
}

interface Pick{
    int digDIAMOND();
    int digIRON();
    int digStone();
}

enum MineralType{
    DIAMOND("diamond", 25),
    IRON("iron", 5),
    STONE("stone", 1);

    private final String type;
    private final int weight;

    MineralType(String type, int weight){
        this.type = type;
        this.weight = weight;
    }

    public static MineralType findType(String type){
        return Arrays
                .stream(values())
                .filter(mineralType -> mineralType.type.equals(type))
                .findAny()
                .orElseThrow();
    }

    public int getWeight() {
        return weight;
    }
}