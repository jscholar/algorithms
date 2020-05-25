import java.util.List;
import java.util.ArrayList;

public class PossibleSquaresInArea {
    public static int[] solution(int area) {
        List<Integer> squares = new ArrayList<>();
        while (area > 0) {
            int sqrt = (int) Math.sqrt(area);
            int square = (int) Math.pow(sqrt, 2);
            squares.add(square);
            area -= square;
        }
        int[] result = new int[squares.size()];
        for (int i = 0; i < squares.size(); i++) {
          result[i] = squares.get(i);
        }
        return result;
    }
}