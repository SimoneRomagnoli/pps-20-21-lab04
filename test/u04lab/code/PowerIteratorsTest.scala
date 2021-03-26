package u04lab.code

import Optionals._
import Lists._
import Lists.List._
import Streams._
import Streams.Stream._
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._
import homework.PowerIteratorImpl

class PowerIteratorsTest {

  val factory = new PowerIteratorsFactoryImpl()
  val list:List[Int] = List.Cons(1, List.Cons(2, List.Cons(3, Nil())))
  val stream:Stream[Int] = take(iterate(1)(_+1))(3)

  @Test
  def testPowerIteratorMethods(): Unit = {
    val pi = PowerIteratorImpl(stream)
    assertEquals(Option.of(1), pi.next())
    assertEquals(List.Cons(1, Nil()), pi.allSoFar())
    assertEquals(Option.of(2), pi.next())
    assertEquals(List.Cons(1, List.Cons(2, Nil())), pi.allSoFar())
    assertEquals(Option.of(3), pi.next())
    assertEquals(List.Cons(1, List.Cons(2, List.Cons(3, Nil()))), pi.allSoFar())
    assertEquals(Option.empty, pi.next())
    assertEquals(List.Cons(1, List.Cons(2, List.Cons(3, Nil()))), pi.allSoFar())

    val pir = pi.reversed()
    assertEquals(Option.of(3), pir.next())
    assertEquals(List.Cons(3, Nil()), pir.allSoFar())
    assertEquals(Option.of(2), pir.next())
    assertEquals(List.Cons(3, List.Cons(2, Nil())), pir.allSoFar())
    assertEquals(Option.of(1), pir.next())
    assertEquals(List.Cons(3, List.Cons(2, List.Cons(1, Nil()))), pir.allSoFar())
    assertEquals(Option.empty, pir.next())
    assertEquals(List.Cons(3, List.Cons(2, List.Cons(1, Nil()))), pir.allSoFar())
  }

  @Test
  def testIncremental() {
    val pi = factory.incremental(5,_+2); // pi produce 5,7,9,11,13,...
    assertEquals(Option.of(5), pi.next());
    assertEquals(Option.of(7), pi.next());
    assertEquals(Option.of(9), pi.next());
    assertEquals(Option.of(11), pi.next());
    assertEquals(List.Cons(5, List.Cons(7, List.Cons(9, List.Cons(11,List.Nil())))), pi.allSoFar()); // elementi già prodotti
    for (i <- 0 until 10) {
      pi.next(); // procedo in avanti per un po'..
    }
    assertEquals(Option.of(33), pi.next()); // sono arrivato a 33
  }

  @Test
  def testFromList(): Unit = {
    println(factory.fromList(list))
    println(PowerIteratorImpl(stream))
  }

  @Test
  def testRandomBooleans(): Unit = {
    print(factory.randomBooleans(5))
  }

}