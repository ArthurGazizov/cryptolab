package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.common;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.service.encoder.Encoder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public abstract class AbstractEncoder<T extends Message, E extends Key> implements Encoder {
  @SuppressWarnings("unchecked")
  @Override
  public Message encode(Message message, Key key) {
    init();
    Message encodedMessage = encodeMessage((T) message, (E) key);
    dispose();
    return encodedMessage;
  }

  protected void init() {
  }

  protected void dispose() {

  }

  protected abstract Message encodeMessage(T message, E key);
}
