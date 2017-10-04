package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common.Processor;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarUtils {
  public static byte[] encode(byte[] message, byte offset) {
    Processor<Byte> processor = new Processor<Byte>()
            .withLocalProcess(CeasarUtils::encode);
    return processor.process(message, offset);
  }

  public static byte[] decode(byte[] message, byte offset) {
    Processor<Byte> processor = new Processor<Byte>()
            .withLocalProcess(CeasarUtils::decode);
    return processor.process(message, offset);
  }

  private static void encode(byte[] message, int startPosition, int endPosition, byte[] destination, byte offset) {
    for (int i = startPosition; i < endPosition; i++) {
      destination[i] = (byte) (message[i] + offset);
    }
  }

  private static void decode(byte[] message, int startPosition, int endPosition, byte[] destination, byte offset) {
    for (int i = startPosition; i < endPosition; i++) {
      destination[i] = (byte) (message[i] - offset);
    }
  }
}
