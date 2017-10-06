package com.hackerrank.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class DestroyBalls {

	public static void main(String[] args) throws Exception{
		IO io=new IO();
		
		int t=io.nextInt();
		for(int i=0;i<t;i++){
			int n=io.nextInt();
			int []balls=new int[n];
			for(int j=0;j<n;j++){
				balls[j]=io.nextInt();
			}
			if(canDestroy1(balls)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}

	}
	
	private static boolean canDestroy1(int[] balls) {
		int destroyed=0;		
		int size=balls.length;
		Arrays.sort(balls);
		
		while(destroyed!=balls.length && destroyed<=balls.length){
			int i=Arrays.binarySearch(balls, size);
			if(i>0){
				balls[i]=-999;
				++destroyed;
			}else{
				size=balls.length-destroyed;
			}
		}
		if(destroyed==balls.length){
			return true;
		}else{
			return false;
		}
		
	}

	private static boolean canDestroy(int[] balls) {
		int destroyedBalls=0;
		int size=balls.length;
		while(destroyedBalls!=balls.length && destroyedBalls<=balls.length){
			size=balls.length-destroyedBalls;
			for(int i=0;i<size;i++){
				if(balls[i]==size){
					++destroyedBalls;
				}
			}
		}
		if(destroyedBalls==balls.length){
			return true;
		}else{
			return false;
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
