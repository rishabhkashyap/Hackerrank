package com.problem.solutions.hackerrank;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SelectiveAdditions {

	public static void main(String[] args) throws Exception {
		// IO io=new IO();
		Scanner io = new Scanner(System.in);
		int n = io.nextInt();
		int m = io.nextInt();
		int k = io.nextInt();
		int[] arr = new int[n];
		int[] fav = new int[k];
		for (int i = 0; i < n; i++) {
			arr[i] = io.nextInt();

		}

		for (int j = 0; j < k; j++) {
			fav[j] = io.nextInt();

		}
		Arrays.sort(fav);
		SegmentTree segTree=new SegmentTree(arr);
		segTree.createSegTree();

		for (int i = 0; i < m; i++) {
			int l = io.nextInt();
			int r = io.nextInt();
			int num = io.nextInt();
			int previous=0;
			l = --l;
			r = --r;
			
			int countOfNotFavNumbers=getCount(l,r,fav,arr,num);
			
			int sum=segTree.getSum(0,arr.length-1);
			sum=previous+sum+countOfNotFavNumbers*num;
			previous=previous+countOfNotFavNumbers*num;
			System.out.println(sum);

		}

	}

	private static int getCount(int l, int r, int[] fav,int[]arr,int num) {
		int count=0;
		for(int i=l;i<=r;i++ ){
			if(Arrays.binarySearch(fav, arr[i])<0){
				++count;
				//arr[i]=arr[i]+num;
			}
			
		}
		return count;
	}



	private static boolean contains(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return true;
			}
		}
		return false;
	}

	 static class SegmentTree {
		private int[] segTree;
		private int[] arr;
		private int start;
		private int end;

		public SegmentTree(int[] arr) {
			this.arr = arr;
			int height = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
			int size = (int) Math.pow(2, height + 1) - 1;
			segTree = new int[size];

		}

		public void createSegTree() {
			createSegTreeUtil(0, arr.length - 1, 0);
		}

		private int createSegTreeUtil(int start, int end, int current) {
			if (start == end) {
				segTree[current] = arr[start];
				return segTree[current];
			} else {
				int mid = mid(start, end);
				segTree[current] = createSegTreeUtil(start, mid, leftChild(current))
						+ createSegTreeUtil(mid + 1, end, rightChild(current));
				return segTree[current];
			}

		}

		public int getSum(int queryStart, int queryEnd) {
			if (queryStart < 0 && queryEnd > segTree.length) {
				return -1;
			} else {
				return getSumUtil(0, arr.length - 1, queryStart, queryEnd, 0);
			}

		}

		private int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int current) {
			// Return value of segTree if there is partial overlap or full
			// overlap of range
			if (queryStart <= startIndex && queryEnd >= endIndex) {
				return segTree[current];
			}
			if (startIndex > queryEnd || endIndex < queryStart) {
				return 0;
			}
			int mid = mid(startIndex, endIndex);

			return getSumUtil(startIndex, mid, queryStart, queryEnd, leftChild(current))
					+ getSumUtil(mid + 1, endIndex, queryStart, queryEnd, rightChild(current));
		}

		private int leftChild(int pos) {
			return 2 * pos + 1;
		}

		private int rightChild(int pos) {
			return 2 * pos + 2;
		}

		private int mid(int start, int end) {
			return (start + (end - start) / 2);
		}

		public void displaySegTree() {
			System.out.println("Size of seg tree = " + segTree.length + "\n");
			System.out.println();
			for (int i : segTree) {
				System.out.print(i + "\t");
			}
		}

	}

	static class IO {
		final private int BUFFER_SIZE = 1 << 21;
		private BufferedInputStream din;
		private BufferedWriter bw;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public IO() throws Exception {

			din = new BufferedInputStream(System.in);
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
