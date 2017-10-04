package com.arthur.gazizov.kpfu.tools.cryptolab.core.factory;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.decoder.Decoder;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.encoder.Encoder;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere.VigenereDecoderImpl;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere.VigenereEncoderImpl;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereCryptoFactoryImpl implements CryptoFactory {
  @Override
  public Encoder encoder() {
    return new VigenereEncoderImpl();
  }

  @Override
  public Decoder decoder() {
    return new VigenereDecoderImpl();
  }
}
