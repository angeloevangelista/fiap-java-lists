package br.com.fiap;

import java.util.Scanner;

public class StackList {
    public static class Stack {
        private Node top;

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

        public int pop()  {
            if (this.isEmpty()) {
                throw  new RuntimeException("Hey! No items to pop in this stack");
            }

            int poppedValue = this.top.value;

            this.top = this.top.next;

            return poppedValue;
        }

        public int top()  {
            if (this.isEmpty()) {
                throw new RuntimeException("Hey! No items in this stack");
            }

            return this.top.value;
        }
    }

    public static void main(String[] args) {
        Scanner stdInScanner = new Scanner(System.in);

        Stack myStack = new Stack();
        myStack.init();

        int option = 0;

        do {
            System.out.print("Type a value to push on stack: ");
            int value = stdInScanner.nextInt();

            myStack.push(value);

            System.out.print("Type 0 to leave: ");
            option = stdInScanner.nextInt();
        } while (option != 0);

        stdInScanner.close();

        System.out.printf("Item on top of stack: %s\n", myStack.top());

        System.out.println("The whole stack:");

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
