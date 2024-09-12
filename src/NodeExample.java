public class NodeExample {
    public static void main(String[] args) {
        Node list = null;

        Node node1 = new Node();
        node1.value = 1;
        node1.next = list;

        list = node1;

        Node node2 = new Node();
        node2.value = 2;
        node2.next = list;

        list = node2;

        Node node3 = new Node();
        node3.value = 3;
        node3.next = list;

        list = node3;

        Node auxiliar = list; // ultimo item da lista

        while (auxiliar != null) {
            System.out.printf("%s -> ", auxiliar.value);

            auxiliar = auxiliar.next;
        }

        System.out.print("NULL");
    }
}