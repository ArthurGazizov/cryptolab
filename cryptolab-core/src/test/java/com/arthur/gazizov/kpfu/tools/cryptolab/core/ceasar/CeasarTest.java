package com.arthur.gazizov.kpfu.tools.cryptolab.core.ceasar;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.AbstractTest;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.factory.CryptoFactorySupplier;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.factory.CryptoFactory;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar.CeasarKey;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarTest extends AbstractTest {
  @Override
  public Supplier<CryptoFactory> getCryptoFactorySupplier() {
    return CryptoFactorySupplier::ceaserCryptoFactory;
  }

  @Override
  public Key generateKey() {
    byte[] value = new byte[1];
    ThreadLocalRandom.current().nextBytes(value);
    return CeasarKey.Builder
            .aCeasarKey()
            .offset(value[0])
            .build();
  }
}
