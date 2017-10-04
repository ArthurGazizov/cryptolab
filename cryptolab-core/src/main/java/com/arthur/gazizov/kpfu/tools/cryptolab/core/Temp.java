package com.arthur.gazizov.kpfu.tools.cryptolab.core;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl.SimpleMessage;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar.CeasarCoderImpl;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar.CeasarDecoderImpl;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar.CeasarKey;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.10.17.
 */
public class Temp {
  public static void main(String[] args) {
    byte[] bytes = new byte[256];
    int temp = 0;
    for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++, temp++) {
      bytes[temp] = (byte) i;
    }
    SimpleMessage message = SimpleMessage.Builder.aSimpleMessage()
            .bytes(bytes)
            .build();
    CeasarKey key = CeasarKey.Builder.aCeasarKey()
            .offset((byte) 10)
            .build();
    CeasarCoderImpl ceasarCoder = new CeasarCoderImpl();
    Message encode = ceasarCoder.encode(message, key);

    CeasarDecoderImpl ceasarDecoder = new CeasarDecoderImpl();
    Message decrypt = ceasarDecoder.decode(encode, key);
    byte[] decryptBytes = decrypt.getBytes();
    int errors = 0;
    for (int i = 0; i < bytes.length; i++) {
      errors += bytes[i] == decryptBytes[i] ? 0 : 1;
    }
    System.err.println(errors);
  }
}
