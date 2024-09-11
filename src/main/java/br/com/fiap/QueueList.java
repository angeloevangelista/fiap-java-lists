package br.com.fiap;

import java.util.Scanner;

public class QueueList {
    public static class Queue {
        private Node front;
        private Node rear;

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
            newNode.next = null;

            if (this.isEmpty()) {
                this.front = newNode;
                this.rear = newNode;
                return;
            }

            this.rear.next = newNode;
            this.rear = newNode;
        }

        public int dequeue()  {
            if (this.isEmpty()) {
                throw new RuntimeException("Hey! No items to dequeue in this queue");
            }

            int dequeueValue = this.front.value;

            this.front = this.front.next;

            if (this.front == null) {
                this.rear = null;
            }

            return dequeueValue;
        }
    }

    public static void main(String[] args) {
        Scanner stdInScanner = new Scanner(System.in);

        Queue myQueue = new Queue();
        myQueue.init();

        int option = 0;

        do {
            System.out.print("Type a value to enqueue on queue: ");
            int value = stdInScanner.nextInt();

            myQueue.enqueue(value);

            System.out.print("Type 0 to leave: ");
            option = stdInScanner.nextInt();
        } while (option != 0);

        stdInScanner.close();

        System.out.println("The whole queue:");

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.dequeue());
        }
    }
}
