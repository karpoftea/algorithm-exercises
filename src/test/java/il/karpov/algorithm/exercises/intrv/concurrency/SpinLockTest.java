package il.karpov.algorithm.exercises.intrv.concurrency;

import il.karpov.algorithm.exercises.intrv.concurrency.SpinLock.SpinLock2Impl;
import il.karpov.algorithm.exercises.intrv.concurrency.SpinLock.SpinLockImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SpinLockTest {

    @Test
    public void testSpinLockImpl() throws InterruptedException {
        testSpinLock(new SpinLockImpl());
    }

    @Test
    public void testSpinLock2Impl() throws InterruptedException {
        testSpinLock(new SpinLock2Impl());
    }

    private void testSpinLock(SpinLock spinLock) throws InterruptedException {
        Counter counter = new Counter();
        int expectedValue = 10_000_000;

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        for (int i = 0; i < expectedValue; i++) {
            pool.submit(new IncrementTask(counter, spinLock));
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        Assert.assertEquals(counter.get(), expectedValue);
    }

    static class IncrementTask implements Runnable {

        private final Counter counter;
        private final SpinLock spinLock;

        public IncrementTask(Counter counter, SpinLock spinLock) {
            this.counter = counter;
            this.spinLock = spinLock;
        }

        @Override
        public void run() {
            spinLock.lock();
            try {
                counter.inc();
            } finally {
                spinLock.unlock();
            }
        }
    }

    static class Counter {

        private int value;

        public void inc() {
            value++;
        }

        public int get() {
            return value;
        }
    }
}
