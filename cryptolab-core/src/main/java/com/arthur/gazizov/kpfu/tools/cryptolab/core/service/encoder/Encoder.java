package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.encoder;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public interface Encoder {
  Message encode(Message message, Key key);
}
