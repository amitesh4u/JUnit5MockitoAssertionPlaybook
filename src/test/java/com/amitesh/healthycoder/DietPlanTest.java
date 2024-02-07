package com.amitesh.healthycoder;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanVerifier;

class DietPlanTest {

  @Test
  void testBean(){
    BeanVerifier.verifyBean(DietPlan.class);
  }

}