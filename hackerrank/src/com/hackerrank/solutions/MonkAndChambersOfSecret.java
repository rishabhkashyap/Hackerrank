package com.hackerrank.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MonkAndChambersOfSecret {

	public static void main(String[] args) throws Exception {
		Queue<Integer> spiders = new LinkedList<>();

		IO io = new IO(false);
		int n = io.nextInt();
		int x = io.nextInt();
		for (int i = 0; i < n; i++) {
			spiders.offer(io.nextInteger());
		}
		// copy content of orignal queue in temporary queue
		Queue<Integer> spidersCopy = new LinkedList<>(spiders);

		for (int k = 0; k < x; k++) {
			int max = findMax(spidersCopy, x);
			System.out.print(locateMax(spiders, max));
		}

	}

	// method takes copy of orignal queue
	// and dequeue x no of elements and copy it in temporary queue
	// It then calls findMaxUtil to find max from temporary queue
	/*
	 * @param Queue<Integer>
	 * 
	 * @returns Integer
	 */
	private static Integer findMax(Queue<Integer> spiders, int x) {
		Integer max = 0;
		ArrayList<Integer> spiderTempQueue = new ArrayList<>();
		// int noOfSpiders=0;
		if (spiders.size() < x) {
			while(!spiders.isEmpty())
				spiderTempQueue.add(spiders.poll());
			
			max = findMaxUtil(spiderTempQueue);
			for (int i = 0; i < spiderTempQueue.size(); i++) {
				int spiderPower = spiderTempQueue.get(i);
				if (spiderPower != max) {

					if (spiderPower == 0) {
						spiders.offer(0);
					} else {
						spiders.offer(spiderPower - 1);
					}

				}
			}

		} else {
			for (int i = 0; i < x; i++) {
				spiderTempQueue.add(spiders.poll());
			}
			max = findMaxUtil(spiderTempQueue);
			for (int i = 0; i < spiderTempQueue.size(); i++) {
				int spiderPower = spiderTempQueue.get(i);
				if (spiderPower != max) {

					if (spiderPower-1 == 0) {
						spiders.offer(spiderPower);
					} else {
						spiders.offer(spiderPower - 1);
					}

				}
			}

		}

		return max;
	}

	private static int findMaxUtil(ArrayList<Integer> spiders) {
		int max = Integer.MIN_VALUE;
		List<Integer> spiderArray = new ArrayList<>(spiders);
		if (spiderArray != null) {
			for (int spider : spiderArray) {
				if (spider > max) {
					max = spider;
				}
			}
		}
		return max;

	}

	private static int locateMax(Queue<Integer> spiders, int max) {
		List<Integer> spiderArray = new ArrayList<>(spiders);
		for (int i = 0; i < spiderArray.size(); i++) {
			if (max == spiderArray.get(i)) {
				return i + 1;
			}
		}
		return -1;
	}

	static class IO {
		final private int BUFFER_SIZE = 1 << 21;
		private BufferedInputStream din;
		private BufferedWriter bw;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public IO(boolean flag) throws Exception {
			if (flag) {
				din = new BufferedInputStream(new FileInputStream("/Users/seeva92/Workspace/Contests/1.txt"));
				bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("/Users/seeva92/Workspace/Contests/2.txt")));
			} else {
				din = new BufferedInputStream(System.in);
				bw = new BufferedWriter(new OutputStreamWriter(System.out));
			}
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			bw.append(object + "\n");
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[BUFFER_SIZE]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public Integer nextInteger() throws IOException {
			Integer ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
			bw.close();
		}
	}

}
