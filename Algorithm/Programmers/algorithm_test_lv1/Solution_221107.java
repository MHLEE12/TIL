import java.util.HashMap;
import java.util.Map;

class Solution_221107 {
    public String solution(String[] survey, int[] choices) {
        // https://school.programmers.co.kr/learn/courses/30/lessons/118666
        // 성격 유형 검사하기

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < survey.length; i++) {
            int value = choices[i];

            if(value > 0 && value < 4) {
                char type = survey[i].charAt(0);
                map.put(type, map.getOrDefault(type, 0) + 4 - value);
            } else if(value > 4) {
                char type = survey[i].charAt(1);
                map.put(type, map.getOrDefault(type, 0) + value - 4);
            }
        }

        return new StringBuilder()
                .append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
                .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
                .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
                .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N')
                .toString();
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        String result = new Solution_221107().solution(survey, choices);
        System.out.println("result = " + result);
        // "TCMA"
    }
}
