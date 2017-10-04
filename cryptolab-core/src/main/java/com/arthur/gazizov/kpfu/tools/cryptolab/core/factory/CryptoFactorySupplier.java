package com.arthur.gazizov.kpfu.tools.cryptolab.core.factory;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CryptoFactorySupplier {
  public static CryptoFactory ceaserCryptoFactory() {
    return new CeasarCryptoFactoryImpl();
  }

  public static CryptoFactory vigenereCryptoFactory() {
    return new VigenereCryptoFactoryImpl();
  }
}
