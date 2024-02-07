//package com.amitesh.junit5core;
//
///**
// * @author Amitesh Kumar
// */
//public class MockAndWhen {
//
//  private final ExternalClass1 externalClass1;
//  private final ExternalClass2 externalClass2;
//  private final ExternalClass3 externalClass3;
//
//  MockAndWhen(ExternalClass1 externalClass1,
//      ExternalClass2 externalClass2, ExternalClass3 externalClass3) {
//    this.externalClass1 = externalClass1;
//    this.externalClass2 = externalClass2;
//    this.externalClass3 = externalClass3;
//  }
//
//  public String callMockAndWhen(){
//    String externalMethod1 = externalClass1.runExternalMethod1();
//    externalMethod1 = externalMethod1.toLowerCase();
//    System.out.println(externalMethod1);
//
//    externalClass2.runExternalMethod2();
//
//    //String s = test();
//
//
//    return externalClass3.runExternalMethod3();
//  }
//
//  public String test(){
//      return null;
//  }
//}
//
//class ExternalClass1{
//
//  public String runExternalMethod1(){
//    return "abc";
//  }
//}
//
//class ExternalClass2{
//
//  public void runExternalMethod2(){
//    System.out.println("do Something");
//  }
//}
//
//class ExternalClass3{
//
//  public String runExternalMethod3(){
//    return "abc";
//  }
//}