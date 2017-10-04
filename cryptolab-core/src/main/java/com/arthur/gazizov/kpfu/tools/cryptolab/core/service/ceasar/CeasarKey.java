package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.ceasar;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class CeasarKey implements Key {
  private byte offset;

  private CeasarKey(byte offset) {
    this.offset = offset;
  }

  public byte getOffset() {
    return offset;
  }

  public static final class Builder {
    private byte offset;

    private Builder() {
    }

    public static Builder aCeasarKey() {
      return new Builder();
    }

    public Builder offset(byte offset) {
      this.offset = offset;
      return this;
    }

    public CeasarKey build() {
      CeasarKey ceasarKey = new CeasarKey(offset);
      return ceasarKey;
    }
  }
}
