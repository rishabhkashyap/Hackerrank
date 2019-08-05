package com.problem.solutions.hackerrank;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestPair {

	public static void main(String[] args) throws Exception {
		IO io=new IO();
		
		int n=io.nextInt();
		int []arr=new int[n];		
		for(int i=0;i<n;i++){
			arr[i]=io.nextInt();
		}
		Arrays.sort(arr);
		List<Integer>pairList=getListOfPairs(getMinAbsoluteDifference(arr), arr);
		Collections.sort(pairList);
		for(int element:pairList){
			System.out.print(element+" ");
		}
		
		
		
		

	}
	
	
	private static List<Integer> getListOfPairs(int lowestDiff,int[]arr){
		List<Integer>pairList=new ArrayList<>();
		for(int i=0;i<arr.length-1;i++){
			if(Math.abs(arr[i]-arr[i+1])==lowestDiff){
				pairList.add(arr[i]);
				pairList.add(arr[i+1]);
			}
		}
		return pairList;
		
	}
	
	
	private static int getMinAbsoluteDifference(int[]arr){
		int minDiff=Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++){
			if(Math.abs(arr[i]-arr[i+1])<minDiff){
				minDiff=Math.abs(arr[i]-arr[i+1]);
			}
		}
		return minDiff;
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
