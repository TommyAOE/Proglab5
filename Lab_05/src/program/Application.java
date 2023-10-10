package program;

public class Application {
	public static void main(String[] args) {
		Fifo FIFO = new Fifo();
		Producer p1 = new Producer("producer", FIFO, 1000);
		Producer p2 = new Producer("producer", FIFO, 1000);
		Producer p3 = new Producer("producer", FIFO, 1000);
		
		Consumer c1 = new Consumer(FIFO, "consumer", 100);
		Consumer c2 = new Consumer(FIFO, "consumer", 100);
		Consumer c3 = new Consumer(FIFO, "consumer", 100);
		Consumer c4 = new Consumer(FIFO, "consumer", 100);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		t1.start();
		t2.start();
		t3.start();
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}
