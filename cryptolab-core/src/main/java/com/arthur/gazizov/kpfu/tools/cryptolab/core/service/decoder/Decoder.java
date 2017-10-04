package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.decoder;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;
import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public interface Decoder {
  Message decode(Message message, Key key);
}
