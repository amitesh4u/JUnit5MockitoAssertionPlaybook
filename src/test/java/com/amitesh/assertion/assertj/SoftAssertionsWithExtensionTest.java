/*
 * Copyright (c) 2022 by Sabre Holdings Corp.
 * 3150 Sabre Drive, Southlake, TX 76092 USA
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Sabre Holdings Corporation
 * ("Confidential Information").  You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with Sabre
 * Holdings Corporation.
 */
package com.amitesh.assertion.assertj;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Amitesh Kumar
 */
@ExtendWith(SoftAssertionsExtension.class)
class SoftAssertionsWithExtensionTest {

  @InjectSoftAssertions
  private SoftAssertions softly;

  @Test
  void chained_soft_assertions_example() {
    String name = "Michael Jordan - Bulls";
    softly.assertThat(name).startsWith("Mi")
        .contains("Bulls");
    // no need to call softly.assertAll(), this is done by the extension
  }

  @Test
  void injected_soft_assertions_example(SoftAssertions softlyInjected) {
    String name = "Michael Jordan - Bulls";
    softlyInjected.assertThat(name).startsWith("Mi")
        .contains("Bulls");
    // no need to call softly.assertAll(), this is done by the extension
  }

  // nested classes test work too
  @Nested
  class NestedExample {

    @Test
    void football_assertions_example() {
      String kylian = "Kylian Mbappé";
      softly.assertThat(kylian).startsWith("Ky")
          .contains("bap");
      // no need to call softly.assertAll(), this is done by the extension
    }
  }
}


    