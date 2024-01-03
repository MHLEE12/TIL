public class Program {
    public static void main(String[] args) {
        GList<Integer> list = new GList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("list" + "[" + i + "] = " + list.get(i));
        }

    }
}
