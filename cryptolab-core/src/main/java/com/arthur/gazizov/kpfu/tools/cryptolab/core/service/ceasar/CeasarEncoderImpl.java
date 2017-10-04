package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl.SimpleMessage;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common.AbstractEncoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarEncoderImpl extends AbstractEncoder<SimpleMessage, CeasarKey> {
  @Override
  protected Message encodeMessage(SimpleMessage message, CeasarKey key) {
    return SimpleMessage.Builder
            .aSimpleMessage()
            .bytes(CeasarUtils.encode(message.getBytes(), key.getOffset()))
            .build();
  }
}
