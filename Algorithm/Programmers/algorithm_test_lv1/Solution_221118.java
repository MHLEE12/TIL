public class Solution_221118 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12903
    // 가운데 글자 가져오기

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int num = s.length() / 2;

        // s의 길이 짝수/홀수 나눠서
        if(s.length() % 2 == 0) {
            // 짝수
            answer.append(s.charAt(num - 1));
            answer.append(s.charAt(num));
        }
        if(s.length() % 2 == 1) {
            // 홀수
            answer.append(s.charAt(num));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
//        String s = "abcde";
        String s = "qwer";
        String result = new Solution_221118().solution(s);
        System.out.println("result = " + result);
    }
}
