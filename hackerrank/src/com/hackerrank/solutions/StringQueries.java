package com.hackerrank.solutions;

//8 2
//abcdabcd
//1 6
//2 7

import java.io.*;
import java.util.*;

class StringQueries {
	static IO io;
	int N, Q, l, r;
	int[][] cnt;
	int[] tempCnt;

	public void init(boolean flag) throws Exception {
		io = new IO(flag);
		N = io.nextInt();
		Q = io.nextInt();
		cnt = new int[N + 7][26];
		tempCnt = new int[26];
		String s = io.readLine();

		for (int i = 1; i <= N; i++) {
			int idx = s.charAt(i - 1) - 'a';
			cnt[i][idx]++;
			for (int j = 0; j < 26; j++)
				cnt[i][j] += cnt[i - 1][j];
		}

		for (int i = 0; i < Q; i++) {
			l = io.nextInt();
			r = io.nextInt();
			int tIdx = 0;
			for (int j = 0; j < 26; j++) {
				if ((cnt[r][j] - cnt[l - 1][j]) > 0) {
					tempCnt[tIdx++] = cnt[r][j] - cnt[l - 1][j];
				}
			}
			int res = (int) 1e9;
			for (int j = 0; j < tIdx; j++) {
				int currCnt = 0;
				for (int k = 0; k < tIdx; k++) {
					if (j != k) {
						if (tempCnt[j] < tempCnt[k])
							currCnt += tempCnt[k] - tempCnt[j];
						else if (tempCnt[j] > tempCnt[k])
							currCnt += tempCnt[k];
					}
				}
				res = Math.min(res, currCnt);
			}
			if (res == (int) 1e9)
				io.println(0);
			else
				io.println(res);
		}
	}

	public static void main(String[] args) throws Exception {
		StringQueries s = new StringQueries();
		s.init(false);
		if (io != null)
			io.close();
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
