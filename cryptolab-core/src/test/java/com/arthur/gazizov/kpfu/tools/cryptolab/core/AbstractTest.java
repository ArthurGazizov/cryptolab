package com.arthur.gazizov.kpfu.tools.cryptolab.core;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl.SimpleMessage;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.factory.CryptoFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public abstract class AbstractTest {
  private static final int TEST_MESSAGE_LENGTH = 10_000;
  protected CryptoFactory cryptoFactory;

  @Before
  public void init() {
    cryptoFactory = getCryptoFactory();
  }

  @Test
  public void test() {
    byte[] originalMessage = new byte[TEST_MESSAGE_LENGTH];
    ThreadLocalRandom.current().nextBytes(originalMessage);

    Message message = boxMessage(originalMessage);
    Key generatedKey = generateKey();

    Message encodedMessage = cryptoFactory
            .encoder()
            .encode(message, generatedKey);

    Message decodedMessage = cryptoFactory
            .decoder()
            .decode(encodedMessage, generatedKey);
    Assert.assertArrayEquals(originalMessage, decodedMessage.getBytes());
  }

  public abstract CryptoFactory getCryptoFactory();

  protected Message boxMessage(byte[] message) {
    return SimpleMessage.Builder
            .aSimpleMessage()
            .bytes(message)
            .build();
  }

  public abstract Key generateKey();
}
