public class Program {
    public static void main(String[] args) {
        ObjectList list = new ObjectList();
        list.add(3);
        list.add(5);
        int size = list.size();
        System.out.printf("size = %d\n", size);

        list.clear();
        size = list.size();
        System.out.printf("size = %d\n", size);

        list.add(7);
        int num = (Integer) list.get(0);
        System.out.printf("num = %d\n", num);

//        num = (Integer) list.get(1); // IndexOutOfBoundsException 발생
    }
}
