package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common.Processor;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereUtils {
  public static byte[] encode(byte[] message, byte[] offsets) {
    Processor<byte[]> processor = new Processor<byte[]>()
            .withLocalProcess(VigenereUtils::encode);
    return processor.process(message, offsets);
  }

  public static byte[] decode(byte[] message, byte[] offsets) {
    Processor<byte[]> processor = new Processor<byte[]>()
            .withLocalProcess(VigenereUtils::decode);
    return processor.process(message, offsets);
  }

  private static void encode(byte[] message, int startPosition, int endPosition, byte[] destination, byte[] offsets) {
    for (int i = startPosition; i < endPosition; i++) {
      destination[i] = (byte) (message[i] + offsets[i % offsets.length]);
    }
  }

  private static void decode(byte[] message, int startPosition, int endPosition, byte[] destination, byte[] offsets) {
    for (int i = startPosition; i < endPosition; i++) {
      destination[i] = (byte) (message[i] - offsets[i % offsets.length]);
    }
  }
}
