package time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2025, 02, 10);
        System.out.println("오늘 날짜 = " + nowDate);
        System.out.println("지정 날짜 = " + ofDate);

        // 계산(불변)
        LocalDate plusDays = ofDate.plusDays(5);
        System.out.println("지정 날짜 + 5d = " + plusDays);
    }
}
