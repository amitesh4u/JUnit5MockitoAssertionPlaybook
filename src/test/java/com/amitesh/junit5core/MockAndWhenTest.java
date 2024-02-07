//package com.amitesh.junit5core;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@Disabled
//@ExtendWith(MockitoExtension.class)
//class MockAndWhenTest {
//
//  @Mock
//  private ExternalClass1 externalClass1;
//
//  @Mock
//  private ExternalClass2 externalClass2;
//
//  @Mock
//  private ExternalClass3 externalClass3;
//
//  @InjectMocks
//  private MockAndWhen mockAndWhen;
//
//
//  @Test
//  void testCallMockVsStub(){
//    when(externalClass1.runExternalMethod1()).thenReturn("ABC");
//
//    doNothing().when(externalClass2).runExternalMethod2();
//
//    when(externalClass3.runExternalMethod3()).thenReturn(null);
//
//    when(mockAndWhen.test()). thenReturn("");
//
//    final String mockAndWhen = this.mockAndWhen.callMockAndWhen();
//    assertThat(mockAndWhen).isNull();
//
//  }
//}