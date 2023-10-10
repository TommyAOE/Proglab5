package program;

public class Producer implements Runnable{
	private String name;
	private int seq;
	private Fifo FIFO;
	private int speed;
	
	public Producer(String n, Fifo f, int s) {
		name = n;
		seq = 0;
		FIFO = f;
		speed = s;
	}
	
	public synchronized void run() {
		while(true) {
			FIFO.interrupt();
			FIFO.put(name);
			FIFO.put(Integer.toString(seq));
			System.out.println(name + "\t" + seq + "\t" + System.currentTimeMillis());
			seq++;
			try {
				Thread.sleep(speed);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
