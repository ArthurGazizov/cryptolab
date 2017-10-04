package com.arthur.gazizov.kpfu.tools.cryptolab.core.factory;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar.CeasarCoderImpl;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar.CeasarDecoderImpl;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.decoder.Decoder;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.encoder.Encoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarCryptoFactoryImpl implements CryptoFactory {
  @Override
  public Encoder encoder() {
    return new CeasarCoderImpl();
  }

  @Override
  public Decoder decoder() {
    return new CeasarDecoderImpl();
  }
}
