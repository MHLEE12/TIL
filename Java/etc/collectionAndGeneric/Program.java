import java.util.*;

public class Program {
    public static void main(String[] args) {
        // 가변길이 배열
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(7);
        list.add(7);
        System.out.println("List => " + list.get(5));
        System.out.println("List size => " + list.size());

        // List는 식별자가 있으나, Set은 식별자가 없음
        // set은 값 자체가 키이므로 중복이 될 수 없다.
        // 중복 제거용
        Set<Object> set = new HashSet<>();
        set.add(3);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(7);
        set.add(7);
        System.out.println(set.add(7)); // 기존에 있던 값이면 false 출력
        System.out.println("Set => " + set.toString());
        System.out.println("Set size => " + set.size());

        // 클래스로 정의하지 않고, 속성과 값으로 구분된 데이터 식별의 개체를 필요로 할 때 사용
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("title", "Hello");
        map.put("hit", 12);

        System.out.println(map.get("title"));
    }
}
