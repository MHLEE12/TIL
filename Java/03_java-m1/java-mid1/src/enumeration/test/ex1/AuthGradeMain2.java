package enumeration.test.ex1;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String grade = s.nextLine();

        // 내가 작성한 답
        /*
        if (grade.equals(AuthGrade.GUEST.name())) {
            commonMenu(AuthGrade.GUEST);
        } else if (grade.equals(AuthGrade.LOGIN.name())) {
            commonMenu(AuthGrade.LOGIN);
            System.out.println("- 이메일 관리 화면");
        } else if (grade.equals(AuthGrade.ADMIN.name())) {
            commonMenu(AuthGrade.ADMIN);
            System.out.println("- 이메일 관리 화면");
            System.out.println("- 관리자 화면");
        }
        */

        AuthGrade authGrade = AuthGrade.valueOf(grade.toUpperCase());
        System.out.println("당신의 등급은 " + authGrade.getDescription() + "입니다.");
        System.out.println("==메뉴 목록==");
        if (authGrade.getLevel() > 0) {
            System.out.println("- 메인 화면");
        }
        if (authGrade.getLevel() > 1) {
            System.out.println("- 이메일 관리 화면");
        }
        if (authGrade.getLevel() > 2) {
            System.out.println("- 관리자 화면");
        }

    }

    // 내가 쓴 것
//    private static void commonMenu(AuthGrade grade) {
//        System.out.println("당신의 등급은 " + grade.name() + "입니다.");
//        System.out.println("==메뉴 목록==");
//        System.out.println("- 메인 화면");
//    }
}
