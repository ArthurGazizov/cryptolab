package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.util.ProcessUtils;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarUtils {
  public static byte[] encode(byte[] message, byte offset) {
    return ProcessUtils.process(message, offset, CeasarUtils::encode);
  }

  public static byte[] decode(byte[] message, byte offset) {
    return ProcessUtils.process(message, offset, CeasarUtils::decode);
  }

  private static void encode(byte[] message
          , int startPosition
          , int endPosition
          , byte[] destination
          , byte offset) {
    for (int i = startPosition; i < endPosition; i++) {
      destination[i] = (byte) (message[i] + offset);
    }
  }

  private static void decode(byte[] message
          , int startPosition
          , int endPosition
          , byte[] destination
          , byte offset) {
    for (int i = startPosition; i < endPosition; i++) {
      destination[i] = (byte) (message[i] - offset);
    }
  }
}
