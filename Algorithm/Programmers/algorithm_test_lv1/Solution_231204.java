import static java.lang.Integer.parseInt;

public class Solution_231204 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java
    // 크기가 작은 부분문자열

    public int solution(String t, String p) {
        int answer = 0;
        int count = t.length() - p.length() + 1;
        int nextNum = 0;

        for(int i = 0; i < count; i++) {
            nextNum = i + p.length();
            if (Long.parseLong(t.substring(i, nextNum)) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int result = new Solution_231204().solution("3141592", "271");
        int result = new Solution_231204().solution("500220839878", "7");
        System.out.printf("result: " + result);
    }
}
