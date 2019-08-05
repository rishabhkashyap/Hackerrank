package com.problem.solutions.hackerrank;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class JumpingCloud {
	 public static void main(String[] args) throws Exception {
	        IO io=new IO();
	        int n = io.nextInt();
	        int c[] = new int[n];
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = io.nextInt();
	           
	        }
	        int hopCount=getMinNoOfHops(c);
            System.out.println(hopCount);
	    }
	    private static int  getMinNoOfHops(int[]c){
	        int hopCount=0;
	        int i=0;
	        while(i<c.length-1){
	            if(i+2<c.length&&c[i+2]!=1){
	                ++hopCount;
	                i+=2;
	                continue;
	            }
	            if(i+1<c.length && c[i+1]!=1){
	                ++i;
	                  ++hopCount;
	                
	            }
	            
	        }
	        return   hopCount;
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
