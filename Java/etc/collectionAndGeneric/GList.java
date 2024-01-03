public class GList<T> {

    private Object[] data;
    private int current;
    private int capacity; // 용량
    private int amount; // 추가 증가량

    public GList() {
        data = new Object[3];
        capacity = 3;
        amount = 5;
        current = 0;
    }

    public void add(T num) {
        if(capacity <= current) {
            Object[] temp = new Object[capacity + amount];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
            capacity += amount;
        }

        data[current] = num;
        current++;
    }

    public void clear() {
        current = 0;
    }

    public int size() {
        return current;
    }

    public T get(int index) {
        if(current <= index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }
}
