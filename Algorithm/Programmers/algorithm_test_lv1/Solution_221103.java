class Solution {
    public String solution(int[] food) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/134240
        //푸드 파이트 대회
        String answer ="";
        String seq = "";
        int num = 0;
        // food[0]은 물을 의미하고 항상 1이니까 빼려고!
        for(int i = 1; i < food.length; i++) {
            num = (food[i] / 2);
            for(int j = 1; j <= num; j++) {
                seq += String.valueOf(i);
            }
        }
        answer = seq + "0";

        StringBuilder sb = new StringBuilder(seq);
        answer += sb.reverse().toString();

        return answer;
    }

//    public static void main(String[] args) {
//        int[] food = {1, 3, 4, 6};
//
//        String result = new Solution().solution(food);
//        System.out.println("result = " + result);
//    }
}

