package com.arthur.gazizov.kpfu.tools.cryptolab.core.service.util;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 04.10.17.
 */
@FunctionalInterface
public interface Consumer5<A, B, C, D, E> {
  void apply(A a, B b, C c, D d, E e);
}
