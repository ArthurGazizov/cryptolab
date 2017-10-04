package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl.SimpleMessage;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common.AbstractDecoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarDecoderImpl extends AbstractDecoder<SimpleMessage, CeasarKey> {
  @Override
  protected Message decodeMessage(SimpleMessage message, CeasarKey key) {
    return SimpleMessage.Builder
            .aSimpleMessage()
            .bytes(CeasarUtils.decode(message.getBytes(), key.getOffset()))
            .build();
  }
}
