package com.iot1.sql;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

   Calc c;

   @Before
   public void setBeforeTest() throws Exception {
      System.out.println(c);
      c = new Calc();
      System.out.println(c);
   }

   @Test
   public void testCalcPlus() {
      int result = c.plus(5, 10);
      assertEquals(15, result,0);
   }

   @Test
   public void testCalcMinus() {
      int result = c.minus(20, 15);
      assertEquals("20-15=5", 5, result,0);
   }

   @Test
   public void testCalcDivide() {
      int result = c.division(30, 6);
      assertEquals("30/6=5", 5, result,0);
   }

   @Test
   public void testCalcMultiple() {
      int result = c.multiple(40, 2);
      assertEquals("40*2=80", 80, result,0);
   }
   @After
   public void setAfterTest() throws Exception {
      System.out.println(c);
      c = null;
   }
}