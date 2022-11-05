import java.util.Stack;

class Solution_221105 {
    public int solution(int[] ingredient) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/133502
        //햄버거 만들기

        Stack<Integer> ham = new Stack<>();

        for(int i = 0; i < ingredient.length; i++) {
            ham.push(ingredient[i]);
//            System.out.println("stack : " + ham.peek());
            System.out.println("ham.size : " + ham.size());
            if(ham.size() >= 4) {
                if (ham.elementAt(ham.size() - 4) == 1 &&
                        ham.elementAt(ham.size() - 3) == 2 &&
                        ham.elementAt(ham.size() - 2) == 3 &&
                        ham.elementAt(ham.size() - 1) == 1) {
                    for(int j = 0; j < 4; j++) {
                        ham.pop();
                    }
                }
            }
        }
        int answer = (ingredient.length - ham.size()) / 4;
        return answer;
    }

    public static void main(String[] args) {
//        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        
        int result = new Solution_221105().solution(ingredient);
        System.out.println("result = " + result);
    }
}
