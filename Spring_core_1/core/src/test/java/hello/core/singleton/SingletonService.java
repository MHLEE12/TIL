package hello.core.singleton;

public class SingletonService {

    //private으로 생성자를 막아두었다. 컴파일 오류가 발생한다.
    //new SingletonService();

    // 관례상 많이 사용..자신을 내부에(private하고) static으로 선언해주면 클래스레벨에 존재하므로 1개만 가짐.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // private 생성자를 쓰면 다른 곳에서 생성하는 것을 막을 수 있음
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
