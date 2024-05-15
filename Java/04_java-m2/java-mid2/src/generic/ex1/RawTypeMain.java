package generic.ex1;

public class RawTypeMain {

    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox(); // 제네릭이 없던 시절의 코드와의 호환을 위해 사용은 할 수 있게 해줌
        //GenericBox<Object> integerBox = new GenericBox<>(); // 권장
        integerBox.set(10);
        Integer result = (Integer) integerBox.get();
        System.out.println("result = " + result);
    }
}
