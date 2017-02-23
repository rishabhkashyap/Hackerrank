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
		Queue<SpiderVal> spiders = new LinkedList<>();

		IO io = new IO(false);
		int n = io.nextInt();
		int x = io.nextInt();
		for (int i = 0; i < n; i++) {
			SpiderVal spiderVal=new SpiderVal(io.nextInt(),i);
			spiders.offer(spiderVal);
		}
		for(int i=0;i<x;i++){
			SpiderVal val=enqueueSpiders(spiders,x);
			if(val!=null){
				System.out.print(val.getPos()+1+" ");
			}
			
		}
		
	}
	
	private static SpiderVal  enqueueSpiders(Queue<SpiderVal>spiders,int x){
		SpiderVal max=null;
		SpiderVal currentSpider=null;
		Queue<SpiderVal>tempQ=new LinkedList<>();
		for(int i=0;i<x;i++){
			if(spiders.isEmpty()){
				break;
			}
			currentSpider=spiders.remove();
			if(max==null||max.getValue()<currentSpider.getValue()){
				max=currentSpider;
			}
			tempQ.add(currentSpider);
			
			
		}
		while(!tempQ.isEmpty()){
			currentSpider=tempQ.remove();
			if(currentSpider!=max){
				if(currentSpider.getValue()!=0){
					currentSpider.setValue(currentSpider.getValue()-1);
				}
				spiders.offer(currentSpider);
				
			}
		}
		return max;
	}


	 
	public static class SpiderVal{
		private int value;
		private int pos;
		
		
		public SpiderVal(int value, int pos) {
			super();
			this.value = value;
			this.pos = pos;
		}
		
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getPos() {
			return pos;
		}
		public void setPos(int pos) {
			this.pos = pos;
		}
		
		
	}
	//IO clas to read and display data
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
