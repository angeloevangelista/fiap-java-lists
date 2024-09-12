public class StackListExample {
    public static class StackList {
        Node top;

        public void init() {
            this.top = null;
        }

        public boolean isEmpty() {
            return this.top == null;
        }

        public void push(int value) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.next = this.top;

            this.top = newNode;
        }

        public int pop() {
            if (this.isEmpty()) {
                throw new RuntimeException("Opa! Não tem nada pra tirar aqui!");
            }

            int poppedValue = this.top.value;

            this.top = this.top.next;

            return poppedValue;
        }

        public int top() {
            if (this.isEmpty()) {
                throw new RuntimeException("Opa! Essa lista está vazia!");
            }

            return this.top.value;
        }

        public int count() {
            int counter = 0;

            Node auxiliar = this.top;

            while (auxiliar != null) {
                counter++;
                auxiliar = auxiliar.next;
            }

            return counter;
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
        System.out.printf("Total na lista: %s\n", myStack.count());

        while (!myStack.isEmpty()) {
            int removedItem = myStack.pop();

            System.out.printf("Item do topo: %s\n", removedItem);
        }
    } // Link do arquivo => https://dontpad.com/morango
}
