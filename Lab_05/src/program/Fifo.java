package program;

import java.util.*;

public class Fifo extends Thread{
	LinkedList<String> buffer = new LinkedList();
	
	public synchronized void put(String str) {
		
		//8ASHOZ KELL DE CSÚNYA
		//System.out.println("put" + Thread.currentThread().getId());
		
		while(buffer.size() >= 10) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		buffer.add(str);
	}
	public synchronized String get() {
		
		//8ASHOZ KELL DE CSÚNYA
		//System.out.println("get" + Thread.currentThread().getId());
		
		boolean isEmpty = true;
		String last = "No element";
		
		if(buffer.size() != 0) {
			last = buffer.getLast();
			isEmpty = false;
		}
		while(buffer.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		if(!isEmpty)
			buffer.removeLast();

		return last;
	}
	
}
