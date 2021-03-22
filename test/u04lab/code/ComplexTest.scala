package u04lab.code

import homework.ComplexImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComplexTest {
  val a = Array(Complex(10,20), Complex(1,1), Complex(7,0))
  val c = a(0) + a(1) + a(2)
  val c2 = a(0) * a(1)

  @Test
  def toStringTest(): Unit = {
    assertEquals("ComplexImpl(18.0,21.0)",c.toString)
    assertEquals("ComplexImpl(-10.0,30.0)",c2.toString)
  }

  @Test
  def equalsTest(): Unit = {
    assertEquals(true,ComplexImpl(18.0,21.0)==c)
    assertEquals(true,ComplexImpl(-10.0,30.0)==c2)
  }

}
