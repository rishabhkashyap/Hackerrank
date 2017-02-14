package com.hackerrank.solutions;

import java.util.Stack;

public class SolutionQueueFromStack {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			stackOldestOnTop.push(value);

		}

		public T peek() {
			if (!stackNewestOnTop.isEmpty()) {
				T t = stackNewestOnTop.peek();
				return t;
			} else {
				while (!stackOldestOnTop.isEmpty()) {
					stackNewestOnTop.push(stackOldestOnTop.pop());
				}
			}
			return stackNewestOnTop.peek();

		}

		public T dequeue() {
			if (!stackNewestOnTop.isEmpty()) {
				return stackNewestOnTop.pop();
			} else {
				while (!stackOldestOnTop.isEmpty()) {
					stackNewestOnTop.push(stackOldestOnTop.pop());
				}
			}

			return stackNewestOnTop.pop();

		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

}
