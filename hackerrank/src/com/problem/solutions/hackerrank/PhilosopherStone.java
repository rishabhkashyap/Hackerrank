package com.problem.solutions.hackerrank;

import java.io.*;
import java.util.Stack;

public class PhilosopherStone {

	public static void main(String[] args) throws Exception {
		IO io = new IO(false);
		int n = io.nextInt();
		int[] coinVals = new int[n];
		// String line = io.readLine();
		// String[]coinStr=line.split(" ");
		int j = 0;
		for (int i = 0; i < n; i++) {
			coinVals[j] = io.nextInt();
			++j;
		}

		// line = io.readLine();
		// String[] vals = line.split(" ");
		int q = io.nextInt();
		int x = io.nextInt();
		String[] cmds = new String[q];
		for (int k = 0; k < q; k++) {
			cmds[k] = io.readLine();
		}

		int count = getCoinCount(n, q, x, coinVals, cmds);
		if (count != -1) {
			System.out.println(count);
		}

	}

	private static int getCoinCount(int n, int q, int x, int[] arr, String[] cmds) {
		IO io;
		int sum = 0;
		Stack<Integer> st = new Stack<>();
		int val = 0;
		try {
			io = new IO(false);
			int j = 0;

			for (int i = 0; i < q; i++) {
				if (cmds[i].equals("Harry")) {
					sum += arr[j];
					if (sum == x) {
						st.push(arr[j]);
						break;
					}
					st.push(arr[j]);
					++j;
				} else if (cmds[i].equals("Remove")) {
					int temp = st.pop();
					sum -= temp;
					if (sum == x) {
						break;
					}
				}
			}
			// while (!st.isEmpty()) {
			// val += st.pop();
			// if (val == x) {
			// return st.size();
			// }
			// }
			return st.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		public long nextLong() throws IOException {
			long ret = 0;
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
