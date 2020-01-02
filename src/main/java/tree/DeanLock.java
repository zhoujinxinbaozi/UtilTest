package tree;

public class DeanLock {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (DeanLock.class){
					System.out.println(Thread.currentThread().getName() + "get DeanLock lock");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (Object.class){
						System.out.println(Thread.currentThread().getName() + "get Object lock");
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (Object.class){
					System.out.println(Thread.currentThread().getName() + "get Object lock");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (DeanLock.class){
						System.out.println(Thread.currentThread().getName() + "get DeanLock lock");
					}
				}
			}
		}).start();
	}
}