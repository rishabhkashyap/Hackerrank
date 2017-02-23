package com.hackerrank.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestClassMonkAndPrisoner {
	
	public static void main(String[]args)throws Exception{
		IO io=new IO(false);
		int n=io.nextInt();
		int []arr=new int[n];
		int [] x=new int[n];
		int []y=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=io.nextInt();
		}
		for(int i=0;i<arr.length;i++){
			getX(arr, x, i);
		}
		getY(arr, y);
		for(int i=0;i<y.length;i++){
			System.out.print(x[i]+y[i]+" ");
		}
		
	}
	private static void getX(int[]arr,int []x,int i){
		if(i==0){
			x[0]=-1;
			
		}else{
			if(arr[i-1]>arr[i]){
				x[i]=i;
			}else{
				int index=x[i-1]-1;
				while(index>=0&&arr[index]<=arr[i]){
					index=x[index]-1;
				}
				x[i]=index<0?-1:index+1;
			}
		}
	}
	
	private  static void getY(int[]arr,int []y){
		y[y.length-1]=-1;
		for(int i=y.length-2;i>=0;i--){
			if(arr[i+1]>arr[i]){
				y[i]=i+2;
			}else{
				int index=y[i+1]-1;
				while(index>=0&&arr[index]<=arr[i]){
					index=y[index]-1;
				}
				y[i]=index<0?-1:index+1;
			}
		}
		
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
