public class QueueListExample {
    public static class QueueList {
        Node front;
        Node rear;

        public void init() {
            this.front = null;
            this.rear = null;
        }

        public boolean isEmpty() {
            return this.front == null && this.rear == null;
        }

        public void enqueue(int value) {
            Node newNode = new Node();
            newNode.value = value;

            if (this.isEmpty()) {
                this.front = newNode;
                this.rear = newNode;
                // eu sou o primeiro e o ultimo, o unico, ninguem atras de mim
            }

            this.rear.next = newNode;
            // Ao ultimo, vai entrar esse aqui atras de voce

            this.rear = newNode;
            // Voce que entrou agora, voce eh o ultimo. Nao tem ninguem ai atras,
            // mas se chegar, eu peco pra ir atras de voce
        }

        public int dequeue() {
            if (this.isEmpty()) {
                throw new RuntimeException("Essa fila não tem itens para serem removidos");
            }

            int dequeuedValue = this.front.value;

            this.front = this.front.next;

            if (this.front == null) {
                this.rear = null;
            }

            return dequeuedValue;
        }

        public int count() {
            if (this.isEmpty()) {
                throw new RuntimeException("A lista esta vazia");
            }

            int counter = 0;

            Node auxiliar = this.front;

            while (auxiliar != null) {
                counter++;

                auxiliar = auxiliar.next;
            }

            return counter;
        }
    }

    public static void main(String[] args) {
        QueueList myQueue = new QueueList();

        myQueue.init();

        myQueue.enqueue(0); // <- Alguem fez um pedido novo
        myQueue.enqueue(2);
        myQueue.enqueue(4);
        myQueue.enqueue(6);
        myQueue.enqueue(8);
        myQueue.enqueue(10);

        System.out.printf("A fila está vazia? %s\n", myQueue.isEmpty());
        System.out.printf("Total na fila: %s\n", myQueue.count());

        // E se eu tentar fechar a pizzaria agora?

        while (!myQueue.isEmpty()) {
            int removedItem = myQueue.dequeue(); // <- Atender um pedido

            System.out.printf("Item do comeco da fila: %s\n", removedItem);
        }

        // que tal tentar fechar agora?
    }
}
