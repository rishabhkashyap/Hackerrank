package com.problem.solutions.hackerrank;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SherlockHomesPairs {
	
	public static void main(String[] args) throws Exception{
		IO io=new IO();
		int t=io.nextInt();
		for(int i=0;i<t;i++){
			int size=io.nextInt();
			int []arr=new int [size];
			for(int j=0;j<size;j++){
				arr[j]=io.nextInt();
			}
			Map<Integer,Integer>frequency=getFrequencyOfEachElement(arr);
			int noOfPair=getNoOfPairs(frequency);
			System.out.println(noOfPair);
			
			
		}
		
		
	}
	
	private static int getNoOfPairs(Map<Integer, Integer> frequency) {
		int frequencyOfElement=0;
		int numberOfPairs=0;
		Set<Integer>elements=frequency.keySet();
		for(int element:elements){
			frequencyOfElement=frequency.get(element);
			int pairs=frequencyOfElement*(frequencyOfElement-1);
			numberOfPairs+=pairs;
		}
		
		return numberOfPairs;
	}

	private static Map<Integer,Integer> getFrequencyOfEachElement(int[]arr){
		Map<Integer,Integer>frequency=new HashMap<>();
		for(int element:arr){
			if(frequency.containsKey(element)){
				int frequencyOfElement=frequency.get(element);
				++frequencyOfElement;
				frequency.put(element, frequencyOfElement);
			}else{
				frequency.put(element, 1);
			}
		}
		return frequency;
		
	}
	
	//IO clas to read and display data
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
