package program;

public class Consumer extends Thread{
	
	private String str;
	private int sleep;
	private Fifo fi;
	
	public Consumer(Fifo f, String s, int n) {
		str = s;
		sleep = n;
		fi = f;
	}
	
	public void run() {
		while(true) {
			String s = fi.get();
			System.out.println(str + "\t" + s + "\t" + System.currentTimeMillis());
			try {
				Thread.sleep(sleep);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
