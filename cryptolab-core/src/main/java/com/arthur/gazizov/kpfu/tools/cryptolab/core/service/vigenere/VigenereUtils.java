package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereUtils {
  public static byte[] encode(byte[] message, byte[] offsets) {
    byte[] encrypted = new byte[message.length];
    int currentOffsetIndex = 0;
    for (int i = 0; i < message.length; i++, currentOffsetIndex = (currentOffsetIndex + 1) % offsets.length) {
      encrypted[i] = (byte) (message[i] + offsets[currentOffsetIndex]);
    }
    return encrypted;
  }

  public static byte[] decode(byte[] message, byte[] offsets) {
    byte[] encrypted = new byte[message.length];
    int currentOffsetIndex = 0;
    for (int i = 0; i < message.length; i++, currentOffsetIndex = (currentOffsetIndex + 1) % offsets.length) {
      encrypted[i] = (byte) (message[i] - offsets[currentOffsetIndex]);
    }
    return encrypted;
  }
}
