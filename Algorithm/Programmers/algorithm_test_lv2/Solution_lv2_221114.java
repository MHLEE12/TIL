public class Solution_lv2_221114 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12909
    // 올바른 괄호
    boolean solution(String s) {
        boolean answer = false;

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            }
            if(s.charAt(i) == ')') {
                count--;
            }
            if(count < 0) {
                break;
            }
        }
        if(count == 0) {
            answer = true;
        }
        return answer;
    }

    public static void main(String[] args) {
//        String s = "()()";
//        String s = "(())()";
        String s = ")()(";
//        String s = "(()(";
        boolean result = new Solution_lv2_221114().solution(s);
        System.out.println("result = " + result);
    }
}
