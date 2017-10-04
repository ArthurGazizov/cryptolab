package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.util.Consumer5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class Processor<E> {
  private static final int MULTITHREADING_USING_THRESHOLD = 2 * 1024 * 1024;
  private static final int BLOCK_SIZE = 1024 * 1024;

  private Consumer5<byte[], Integer, Integer, byte[], E> consumer;

  public Processor() {
  }

  public Processor<E> withLocalProcess(Consumer5<byte[], Integer, Integer, byte[], E> consumer) {
    this.consumer = consumer;
    return this;
  }

  public byte[] process(byte[] message, E param) {
    byte[] processed = new byte[message.length];
    if (message.length < MULTITHREADING_USING_THRESHOLD) {
      consumer.apply(message, 0, message.length, processed, param);
    } else {
      int blocksCount = (processed.length / BLOCK_SIZE) + (processed.length % BLOCK_SIZE == 0 ? 0 : 1);
      ExecutorService executorService = Executors.newFixedThreadPool(blocksCount);
      for (int threadId = 0; threadId < blocksCount; threadId++) {
        final int startIndex = threadId * BLOCK_SIZE;
        final int endIndex = Math.min(startIndex + BLOCK_SIZE, message.length);
        executorService.execute(() -> consumer.apply(message, startIndex, endIndex, processed, param));
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
