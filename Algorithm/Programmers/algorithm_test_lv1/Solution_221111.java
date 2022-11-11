public class Solution_221111 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i] == false) {
                absolutes[i] = absolutes[i] * (-1);
            }
            answer += absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] absolutes = {4, 7, 12};
//        boolean[] signs = {true, false, true};

        int[] absolutes = {1,2,3};
        boolean[] signs = {false,false,true};

        int result = new Solution_221111().solution(absolutes, signs);
        System.out.println("result = " + result);

    }
}
