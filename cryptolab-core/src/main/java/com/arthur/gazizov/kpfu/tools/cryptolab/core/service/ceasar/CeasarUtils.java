package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarUtils {
  public static byte[] encode(byte[] message, byte offset) {
    byte[] encrypted = new byte[message.length];
    for (int i = 0; i < message.length; i++) {
      encrypted[i] = (byte) (message[i] + offset);
    }
    return encrypted;
  }

  public static byte[] decode(byte[] message, byte offset) {
    byte[] encrypted = new byte[message.length];
    for (int i = 0; i < message.length; i++) {
      encrypted[i] = (byte) (message[i] - offset);
    }
    return encrypted;
  }
}
