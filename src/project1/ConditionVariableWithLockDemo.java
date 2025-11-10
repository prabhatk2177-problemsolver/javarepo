package project1;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;

class SharedResourceWithLock {
    private List<Integer> list = new ArrayList<>();
    private final int CAPACITY = 5;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            lock.lock();
            try {
                // Wait if the list is full
                while (list.size() == CAPACITY) {
                    notFull.await();
                }
                System.out.println("Produced: " + value);
                list.add(value++);
                notEmpty.signal();  // Signal the consumer
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                // Wait if the list is empty
                while (list.isEmpty()) {
                    notEmpty.await();
                }
                int value = list.remove(0);
                System.out.println("Consumed: " + value);
                notFull.signal();  // Signal the producer
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000);
        }
    }
}

public class ConditionVariableWithLockDemo {
    public static void main(String[] args) {
        SharedResourceWithLock resource = new SharedResourceWithLock();

        Thread producerThread = new Thread(() -> {
            try {
                resource.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

