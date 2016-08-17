/**
 * Created by jackson on 17/08/16.
 */
public class BinaryGap {

    public static Integer solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        String[] splitedString = binaryString.split("");
        Integer maxGap = 0;
        Integer currentGap = 0;

        for (String s : splitedString) {
            if (s.equals("0")) {
                currentGap++;
            } else {
                if (currentGap > maxGap) maxGap = currentGap;
                currentGap = 0;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(328));
        System.out.println(solution(5));
        System.out.println(solution(15));
    }
}
