public class Solution_221108 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/133499
    // 옹알이(2)

    public int solution(String[] babbling) {
        int answer = 0;

        String[] baby = {"aya", "ye", "woo", "ma"};

        for(int i = 0; i < babbling.length; i++) {
            for(int j = 0; j < baby.length; j++) {
                if(babbling[i].contains(baby[j]) && !babbling[i].contains(baby[j].repeat(2))) {
                    babbling[i] = babbling[i].replace(baby[j], "z");
                }
            }
            System.out.println(i + "번째 " + babbling[i]);
//            babbling[i] = babbling[i].replaceAll("z", "");
//            if(babbling[i] == "") {
//                answer++;
        }

        for(int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("z", "");
            if(babbling[i] == "") {
                answer++;
                System.out.println(answer);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // result = 1
        String[] babbling = {"aya", "yee", "u", "maa"};

        // result = 2
//        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        // result = 3
//        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", "wooyemawooye", "myea"};

        int result = new Solution_221108().solution(babbling);
        System.out.println("result = " + result);
    }
}
