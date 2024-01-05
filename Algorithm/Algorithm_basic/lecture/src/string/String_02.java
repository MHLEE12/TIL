package string;

import java.util.Scanner;

public class String_02 {
    /**
     * 2. 대소문자 변환
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     *
     * - 입력
     * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     *
     * - 출력
     * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     */

//    public String solution(String str) {
//        char[] arr = str.toCharArray();
//        String result = "";
//        for(int i = 0; i < str.length(); i++) {
//            int a = arr[i];
//            int b = Character.toUpperCase(arr[i]);
//            int c = Character.toLowerCase(arr[i]);
//            if (a == b) {
//                arr[i] = Character.toLowerCase(arr[i]);
//            } else if (a == c) {
//                arr[i] = Character.toUpperCase(arr[i]);
//            }
//            result += arr[i];
//        }
//        return result;
//    }

//    public String solution(String str) {
//        String result = "";
//        for(char x : str.toCharArray()) {
//            if (Character.isLowerCase(x)) result += Character.toUpperCase(x);
//            else result += Character.toLowerCase(x);
//        }
//        return result;
//    }

    public String solution(String str) {
        String result = "";
        for(char x : str.toCharArray()) {
            if (x >= 65 && x <=90) { // char는 정수형이므로 정수비교 가능
                // 대문자
                result += (char)(x + 32); // 대소문자의 차이는 32
            } else if (x >= 97 && x <= 122)
                // 소문자
                result += (char)(x - 32);
        }
        return result;
    }

    public static void main(String[] args) {
        String_02 str02 = new String_02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(str02.solution(str));
    }
}
