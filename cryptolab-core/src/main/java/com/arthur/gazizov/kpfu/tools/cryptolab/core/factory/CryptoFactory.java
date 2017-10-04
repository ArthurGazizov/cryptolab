package com.arthur.gazizov.kpfu.tools.cryptolab.core.factory;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.decoder.Decoder;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.encoder.Encoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public interface CryptoFactory {
  Encoder encoder();

  Decoder decoder();
}
