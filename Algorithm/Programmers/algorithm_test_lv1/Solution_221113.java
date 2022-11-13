public class Solution_221113 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12948
    // 핸드폰 번호 가리기

    public String solution(String phone_number) {
        String answer = "";

        StringBuffer sb = new StringBuffer(phone_number);
        sb.delete(0, (phone_number.length() - 4));
        for(int i = 0; i < (phone_number.length() - 4); i++) {
            answer += "*";
        }
        answer += sb.toString();

        return answer;
    }

    public static void main(String[] args) {
//        String pNum = "01033334444";
        String pNum = "027778888";
        String result = new Solution_221113().solution(pNum);
        System.out.println("result = " + result);
    }
}
