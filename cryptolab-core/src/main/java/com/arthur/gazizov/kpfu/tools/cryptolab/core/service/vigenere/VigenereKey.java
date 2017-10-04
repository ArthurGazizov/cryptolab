package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.vigenere;

import com.arthur.gazizov.kpfu.tools.cryptolab.core.bean.Key;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
public class VigenereKey implements Key {
  private byte[] offsets;

  public VigenereKey() {
  }

  public byte[] getOffsets() {
    return offsets;
  }

  public static final class Builder {
    private byte[] offsets;

    private Builder() {
    }

    public static Builder aVigenereKey() {
      return new Builder();
    }

    public Builder offsets(byte[] offsets) {
      this.offsets = offsets;
      return this;
    }

    public VigenereKey build() {
      VigenereKey vigenereKey = new VigenereKey();
      vigenereKey.offsets = this.offsets;
      return vigenereKey;
    }
  }
}
