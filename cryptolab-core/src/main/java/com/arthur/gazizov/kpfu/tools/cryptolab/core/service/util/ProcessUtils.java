package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class ProcessUtils {
  private static final int MULTITHREADING_USING_THRESHOLD = 2 * 1024;
  private static final int BLOCK_SIZE = 1024;

  public static<E> byte[] process(byte[] message, E param, Consumer5<byte[], Integer, Integer, byte[], E> consumer5) {
    byte[] processed = new byte[message.length];
    if (message.length < MULTITHREADING_USING_THRESHOLD) {
      consumer5.apply(message, 0, message.length, processed, param);
    } else {
      int blocksCount = (processed.length / BLOCK_SIZE) + (processed.length % BLOCK_SIZE == 0 ? 0 : 1);
      ExecutorService executorService = Executors.newFixedThreadPool(blocksCount);
      for (int threadId = 0; threadId < blocksCount; threadId++) {
        final int startIndex = threadId * BLOCK_SIZE;
        final int endIndex = Math.min(startIndex + BLOCK_SIZE, message.length);
        executorService.execute(() -> consumer5.apply(message, startIndex, endIndex, processed, param));
      }
      executorService.shutdown();
      try {
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    return processed;
  }
}
