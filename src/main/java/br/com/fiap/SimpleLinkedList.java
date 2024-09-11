package br.com.fiap;

public class SimpleLinkedList {
    public static void main(String[] args) {
        Node list = null;

        for (int i = 1; i < 10; i++) {
            Node node = new Node();
            node.next = list;
            node.value = i;

            list = node;
        }

        Node auxiliar = list;

        while (auxiliar != null){
            System.out.printf("Current node value: %s\n", auxiliar.value);

            auxiliar = auxiliar.next;
        }
    }
}
