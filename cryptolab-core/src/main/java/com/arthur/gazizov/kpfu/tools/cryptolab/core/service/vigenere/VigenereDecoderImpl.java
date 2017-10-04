package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl.SimpleMessage;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common.AbstractDecoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereDecoderImpl extends AbstractDecoder<SimpleMessage, VigenereKey> {
  @Override
  protected Message decodeMessage(SimpleMessage message, VigenereKey key) {
    return SimpleMessage.Builder
            .aSimpleMessage()
            .bytes(VigenereUtils.decode(message.getBytes(), key.getOffsets()))
            .build();
  }
}
