package il.karpov.algorithm.exercises.intrv.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p><b>Problem</b>: create an implementation of simple lock. Implementation must not use 'synchronized' keyword,
 * 'java.util.concurrent' synchronizers and 'java.util.concurrent.locks'.
 * It can use 'volatile' keyword and 'java.util.concurrent.atomic.*' classes.
 * </p>
 * <p><b>Thanks to</b>: <a href="https://www.ooma.com/">OOMA</a> tech team.</p>
 */
public interface SpinLock {
    /**
     * Interface for primitive lock: lock can be acquired by a thread if only it is not already acquired by another
     * thread. If it is acquired by another thread, then thread block on {@link SpinLock#lock()} method until another
     * thread will unlock it by {@link SpinLock#unlock()} method.
     */
    void lock();

    /**
     * Tries to release lock. If lock is held by another thread, then no effect is expected. If lock is held by
     * current thread then lock must be release, i.e. another thread can acquire it.
     * Implementations <em>must</em> enforce the same memory synchronization semantics as provided
     * by the built-in monitor lock.
     */
    void unlock();


    class SpinLockImpl implements SpinLock {

        // use negative value because Thread#getId returns only positives
        private static final long NO_THREAD = -1L;

        private final AtomicBoolean acquired = new AtomicBoolean(false);
        private final AtomicLong threadId = new AtomicLong(NO_THREAD);

        @Override
        public void lock() {
            while (!acquired.compareAndSet(false, true)) ;
            threadId.set(Thread.currentThread().getId());
        }

        @Override
        public void unlock() {
            if (threadId.get() != Thread.currentThread().getId()) return;
            acquired.set(false);
        }
    }

    class SpinLock2Impl implements SpinLock {

        private final AtomicReference<Thread> threadRef = new AtomicReference<>();

        @Override
        public void lock() {
            while (!threadRef.compareAndSet(null, Thread.currentThread())) ;
        }

        @Override
        public void unlock() {
            threadRef.compareAndSet(Thread.currentThread(), null);
        }
    }

}
