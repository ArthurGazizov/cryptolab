package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.decoder.Decoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public abstract class AbstractDecoder<T extends Message, E extends Key> implements Decoder {
  @SuppressWarnings("unchecked")
  @Override
  public Message decode(Message message, Key key) {
    init();
    Message decodedMessage = decodeMessage((T) message, (E) key);
    dispose();
    return decodedMessage;
  }

  protected void init() {
  }

  protected void dispose() {

  }

  protected abstract Message decodeMessage(T message, E key);
}
