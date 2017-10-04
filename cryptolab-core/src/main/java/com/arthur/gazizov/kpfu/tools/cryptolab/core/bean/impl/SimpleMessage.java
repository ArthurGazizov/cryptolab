package com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.impl;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Message;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class SimpleMessage implements Message {
  private byte[] bytes;

  private SimpleMessage() {
  }

  @Override
  public byte[] getBytes() {
    return bytes;
  }

  public static final class Builder {
    private byte[] bytes;

    private Builder() {
    }

    public static Builder aSimpleMessage() {
      return new Builder();
    }

    public Builder bytes(byte[] bytes) {
      this.bytes = bytes;
      return this;
    }

    public SimpleMessage build() {
      SimpleMessage simpleMessage = new SimpleMessage();
      simpleMessage.bytes = this.bytes;
      return simpleMessage;
    }
  }
}
