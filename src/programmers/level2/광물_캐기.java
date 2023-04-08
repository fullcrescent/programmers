package programmers.level2;

import java.util.*;
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
        return Minerals.of(minerals).digInMinFatigue(Picks.of(picks));
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

    public int digFrom(Pick pick) {
        return minerals.stream()
                .mapToInt(pick::dig)
                .sum();
    }

    public int digInMinFatigue(Picks picks) {
        int fatigue = 0;

        List<Minerals> toDig = IntStream.range(0, Integer.min(picks.size(),
                        minerals.size() / 5 + (minerals.size() % 5 > 0 ? 1 : 0)))
                .mapToObj(i -> minerals.subList(i * 5, Integer.min(5 + i * 5, minerals.size())))
                .map(Minerals::new)
                .sorted(compareTo().reversed())
                .collect(Collectors.toList());

        for (Minerals next : toDig) {
            Optional<Pick> pick = picks.pollFor(next);

            if (pick.isEmpty()) {
                break;
            }
            fatigue += pick.get().dig(next);
        }

        return fatigue;
    }

    private Comparator<Minerals> compareTo() {
        return Comparator.comparingInt(a -> a.minerals.stream()
                .mapToInt(Mineral::weight)
                .sum());
    }
}

class Mineral{
    private static final Map<MineralType, Function<Pick, Integer>> DIGGING = Map
            .of(
                    MineralType.DIAMOND, Pick::digDiamond
                    ,MineralType.IRON, Pick::digIron
                    ,MineralType.STONE, Pick::digStone
            );
    private final MineralType mineralType;

    public Mineral(MineralType mineralType) {
        this.mineralType = mineralType;
    }

    public int digFrom(Pick pick) {
        return DIGGING.get(mineralType).apply(pick);
    }

    public int weight() {
        return mineralType.getWeight();
    }
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

class Picks {
    private final List<Pick> picks;

    public Picks(List<Pick> picks) {
        this.picks = picks;
    }

    public static Picks of(int[] picks) {
        return new Picks(List.of(
                new DiamondPick(picks[0]),
                new IronPick(picks[1]),
                new StonePick(picks[2])
        ));
    }

    public Optional<Pick> pollFor(Minerals minerals) {
        return picks.stream()
                .filter(Pick::isNotEmpty)
                .min(Comparator.comparingInt(pick -> pick.dig(minerals)))
                .map(pick -> {
                    pick.decrease();
                    return pick;
                });
    }

    public int size() {
        return picks.stream()
                .mapToInt(Pick::getSize)
                .sum();
    }
}

interface Pick{
    int dig(Minerals minerals);
    int dig(Mineral mineral);
    int digDiamond();
    int digIron();
    int digStone();
    void decrease();
    boolean isNotEmpty();
    int getSize();
}

abstract class AbstractPick implements Pick {
    protected MineralType mineralType;
    protected Integer count;

    public AbstractPick(MineralType mineralType, int count) {
        this.mineralType = mineralType;
        this.count = count;
    }

    @Override
    public int dig(Minerals minerals) {
        return minerals.digFrom(this);
    }

    @Override
    public int dig(Mineral mineral) {
        return mineral.digFrom(this);
    }

    @Override
    public void decrease() {
        count--;
    }

    @Override
    public boolean isNotEmpty() {
        return count > 0;
    }

    @Override
    public int getSize() {
        return count;
    }
}

class DiamondPick extends AbstractPick {
    public DiamondPick(int count) {
        super(MineralType.DIAMOND, count);
    }

    @Override
    public int digDiamond() {
        return 1;
    }

    @Override
    public int digIron() {
        return 1;
    }

    @Override
    public int digStone() {
        return 1;
    }
}

class IronPick extends AbstractPick {
    public IronPick(int count) {
        super(MineralType.DIAMOND, count);
    }

    @Override
    public int digDiamond() {
        return 5;
    }

    @Override
    public int digIron() {
        return 1;
    }

    @Override
    public int digStone() {
        return 1;
    }
}

class StonePick extends AbstractPick {
    public StonePick(int count) {
        super(MineralType.DIAMOND, count);
    }

    @Override
    public int digDiamond() {
        return 25;
    }

    @Override
    public int digIron() {
        return 5;
    }

    @Override
    public int digStone() {
        return 1;
    }
}