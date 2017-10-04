package com.arthur.gazizov.kpfu.tools.cryptolab.core.vigenere;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.AbstractTest;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.factory.CryptoFactorySupplier;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.factory.CryptoFactory;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere.VigenereKey;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereTest extends AbstractTest {

  @Override
  public Supplier<CryptoFactory> getCryptoFactorySupplier() {
    return CryptoFactorySupplier::vigenereCryptoFactory;
  }

  @Override
  public Key generateKey() {
    byte[] offsets = new byte[(Math.abs(ThreadLocalRandom.current().nextInt()) % 1000) + 1];
    return VigenereKey.Builder
            .aVigenereKey()
            .offsets(offsets)
            .build();
  }
}
