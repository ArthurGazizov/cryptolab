package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl.SimpleMessage;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common.AbstractEncoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereEncoderImpl extends AbstractEncoder<SimpleMessage, VigenereKey> {
  @Override
  protected Message encodeMessage(SimpleMessage message, VigenereKey key) {
    return SimpleMessage.Builder
            .aSimpleMessage()
            .bytes(VigenereUtils.encode(message.getBytes(), key.getOffsets()))
            .build();
  }
}
