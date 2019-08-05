package com.problem.solutions.hackerrank;

import java.io.*;

public class TestClass1 {
	
	
	public static void main(String[] args) throws Exception {
		IO io = new IO(false);		
		int n=io.nextInt();
		int []arr=new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]=io.nextInt();
			
		}
		int q=io.nextInt();
		for(int j=0;j<q;j++){
			int l=io.nextInt();
			int r=io.nextInt();
			int lLoc=getLocation(arr, l);
			int temp=arr[arr.length-(lLoc+1)];
			arr[arr.length-(lLoc+1)]=l;
			arr[lLoc]=temp;
			int rLoc=getLocation(arr, r);
			temp=arr[arr.length-(rLoc+1)];
			arr[arr.length-(rLoc+1)]=r;
			arr[rLoc]=temp;
			
			
		}
		
		for(int ele:arr){
			System.out.print(ele+"  ");
		}
	}
	private static int getLocation(int[]arr,int element){
		int loc=-1;
		for(int i=0;i<arr.length;i++ ){
			if(element==arr[i]){
				loc=i;
				break;
			}
		}
		return loc;
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
