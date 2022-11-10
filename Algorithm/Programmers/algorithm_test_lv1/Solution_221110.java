public class Solution_221110 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12918
    // 문자열 다루기 기본

    public boolean solution(String s) {
        int numCheck = 0;

        if(s.length() == 4 || s.length() == 6) {
            for(int i = 0; i < s.length(); i++) {
                numCheck = Integer.valueOf(s.charAt(i));
                if(!(numCheck >= 48 && numCheck <=57)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "a234";
        String s = "1234";
        boolean result = new Solution_221110().solution(s);
        System.out.println("result = " + result);
    }
}
