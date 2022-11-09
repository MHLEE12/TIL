import java.util.ArrayList;
import java.util.Collections;

public class Solution_lv2_221109 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12939
    // 최댓값과 최솟값
    public String solution(String s) {
        String answer = "";

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        String[] arr2 = s.split(" ");

        for(int i = 0; i < arr2.length; i++) {
            arr1.add(Integer.valueOf(arr2[i]));
        }
        answer = Collections.min(arr1) + " " + Collections.max(arr1);

        return answer;
    }

    public static void main(String[] args) {
//        String input = "1 2 3 4";
        String input = "-1 -2 -3 -4";

        String result = new Solution_lv2_221109().solution(input);
        System.out.println("result = " + result);

    }
}
