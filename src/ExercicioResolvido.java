public class ExercicioResolvido {
    public static class Node {
        int value;
        int count;
        Node next;
    }

    public static class StackList {
        Node top;
        int countNumber = 0;

        public void init() {
            this.top = null;
            int countNumber = 0;
        }

        public boolean isEmpty() {
            return this.top == null;
        }

        public void push(int value) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.count = this.countNumber++;
            newNode.next = this.top;

            this.top = newNode;
        }

        public int pop() {
            if (this.isEmpty()) {
                throw new RuntimeException("Opa! Não tem nada pra tirar aqui!");
            }

            int poppedValue = this.top.value;

            this.top = this.top.next;

            this.countNumber--;

            return poppedValue;
        }

        public int top() {
            if (this.isEmpty()) {
                throw new RuntimeException("Opa! Essa lista está vazia!");
            }

            return this.top.value;
        }
    }

    public static void main(String[] args) {
        StackList myStack = new StackList();

        myStack.init();

        myStack.push(2);
        myStack.push(4);
        myStack.push(6);
        myStack.push(8);
        myStack.push(10);


        System.out.printf("A pilha está vazia? %s\n", myStack.isEmpty());

        while (!myStack.isEmpty()) {
            System.out.printf("Tamanho da lista: %s\n", myStack.countNumber);

            int removedItem = myStack.pop();

            System.out.printf("Item do topo: %s\n", removedItem);
        }
    }
}

