package com.amitesh.junit5core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockVsSpyTest {

  @Mock
  private List<String> mockList;

  @Spy
  private List<String> spyList = new ArrayList<>();

  @Test
  void testMockList() {
    //by default, calling the methods of mock object will do nothing
    mockList.add("test");

    verify(mockList).add("test");
    assertThat(mockList.size()).isZero();
  }

  @Disabled("Issue with jdk 14+")
  @Test
  void testSpyList() {
    //spy object will call the real method when not stub
    spyList.add("test");

    verify(spyList).add("test");
    assertThat(spyList).hasSize(1);
    assertThat(spyList.getFirst()).isEqualTo("test");
  }

  @Test
  void testMockWithStub() {
    //try stubbing a method
    String expected = "Mock 100";
    when(mockList.get(100)).thenReturn(expected);

    assertThat(mockList.get(100)).isEqualTo(expected);
  }

  @Test
  void testSpyWithStub() {
    //stubbing a spy method will result the same as the mock object
    String expected = "Spy 100";
    //take note of using doReturn instead of when
    doReturn(expected).when(spyList).get(100);

    assertThat(spyList.get(100)).isEqualTo(expected);
  }
}