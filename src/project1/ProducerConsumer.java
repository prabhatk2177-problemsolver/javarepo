package project1;

class SharedResource {
	private int data;
	private boolean available = false;

	synchronized void produce(int i) throws InterruptedException {
		while (available) {
			wait();
		}

		// data is consumed
		data = i;
		available = true;
		System.out.println("Produced " + i);
		notify();

	}

	synchronized int consume() throws InterruptedException {
		while (!available) {
			wait();
		}

		// Now data is available..go ahead and consume it.
		available = false;
		System.out.println("Consumed" + data);
		notify();

		return data;
	}

}

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		SharedResource s1 = new SharedResource();
		Thread producer = new Thread(() -> {
			for (int i = 0; i < 1; i++) {
				try {
					s1.produce(i);
					//System.out.println("Produced " + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}

			}
		}

		);

		Thread consumer = new Thread(() -> {
			for (int i = 0; i < 1; i++) {
				try {
					int value = s1.consume();
					//System.out.println("Consumed" + value);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}

			}
		}

		);

		
		consumer.start();
		
		Thread.sleep(10000);
		producer.start();
		System.out.println("IN MAIN");
	}

}
