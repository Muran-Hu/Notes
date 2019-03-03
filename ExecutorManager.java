package com.droid.java;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Muran Hu on 2019-03-03.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class ExecutorManager {

  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  // We want at least 2 threads and at most 4 threads in the core pool,
  // preferring to have 1 less than the CPU count to avoid saturating
  // the CPU with background work
  private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
  private static final int KEEP_ALIVE_SECONDS = 30;

  private static final ThreadFactory sThreadFactory = new ThreadFactory() {
    private final AtomicInteger mCount = new AtomicInteger(1);

    public Thread newThread(Runnable r) {
      return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
    }
  };

  private static final BlockingQueue<Runnable> sPoolWorkQueue =
          new LinkedBlockingQueue<Runnable>(128);

  /**
   * An {@link Executor} that can be used to execute tasks in parallel.
   */
  public static final Executor THREAD_POOL_EXECUTOR;

  static {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
            sPoolWorkQueue, sThreadFactory);
    threadPoolExecutor.allowCoreThreadTimeOut(true);
    THREAD_POOL_EXECUTOR = threadPoolExecutor;
  }

  public static Executor createExecutor() {
    return THREAD_POOL_EXECUTOR;
  }
}
