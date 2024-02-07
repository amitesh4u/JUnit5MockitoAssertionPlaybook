package com.amitesh.healthycoder;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanVerifier;

class CoderTest {

  @Test
  void testBean(){
    BeanVerifier.verifyBean(Coder.class);
  }

}