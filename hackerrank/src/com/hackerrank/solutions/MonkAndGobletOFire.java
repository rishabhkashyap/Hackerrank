package com.hackerrank.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MonkAndGobletOFire {

	public static void main(String[] args) throws Exception {
		IO io = new IO(false);
		int operations = io.nextInt();
		String inputLine = null;
		// System.out.println(inputLine);
		ArrayList<Student> studentsQueue = new ArrayList<>();
		for (int i = 0; i < operations; i++) {
			inputLine = io.readLine();
			if (inputLine.charAt(0) == 'E'){
				int school=inputLine.charAt(2);
				int rollNo=inputLine.charAt(4);
				Student student=new Student(school-48,rollNo-48);
				enqueue(studentsQueue,student);
			}else{
				Student student=studentsQueue.remove(0);
				System.out.println(student.getSchool()+" "+student.getRollNo());
			}
				

		}

	}

	private static void enqueue(ArrayList<Student> studentsQueue, Student student) {
		ArrayList<Student>tempStudentQueue=new ArrayList<>();
		if(studentsQueue.size()==0){
			studentsQueue.add(student);
		}else{
			if(studentsQueue.get(studentsQueue.size()-1).getSchool()==student.getSchool()){
				studentsQueue.add(student);
			}else{
				int count=0;
				int size=studentsQueue.size()-1;
				while(studentsQueue.size()>0 && studentsQueue.get(size).getSchool()!=student.getSchool() ){
					tempStudentQueue.add(studentsQueue.remove(size));
					--size;
				}
				studentsQueue.add(student);
				for(int i=0;i<tempStudentQueue.size();i++){
					studentsQueue.add(tempStudentQueue.remove(i));
				}
			}
		}
		
	}

	public static class Student {
		private int school;
		private int rollNo;

		public Student(int school, int rollNo) {
			super();
			this.school = school;
			this.rollNo = rollNo;
		}

		public int getSchool() {
			return school;
		}

		public void setSchool(int school) {
			this.school = school;
		}

		public int getRollNo() {
			return rollNo;
		}

		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
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
