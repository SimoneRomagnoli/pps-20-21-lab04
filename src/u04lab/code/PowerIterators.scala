package u04lab.code

import Optionals._
import Lists._
import homework.PowerIteratorImpl
import Streams._
import Streams.Stream._
import u04lab.code.Lists.List._

import scala.util.Random

trait PowerIterator[A] {
  def next(): Option[A]
  def allSoFar(): List[A]
  def reversed(): PowerIterator[A]
}

trait PowerIteratorsFactory {

  def incremental(start: Int, successive: Int => Int): PowerIterator[Int]
  def fromList[A](list: List[A]): PowerIterator[A]
  def randomBooleans(size: Int): PowerIterator[Boolean]
}

class PowerIteratorsFactoryImpl extends PowerIteratorsFactory {

  override def incremental(start: Int, successive: Int => Int): PowerIterator[Int] =
    PowerIteratorImpl(Stream.iterate(start)(successive))

  override def fromList[A](list: List[A]): PowerIterator[A] =
    PowerIteratorImpl(toStream(list))

  override def randomBooleans(size: Int): PowerIterator[Boolean] = {
    PowerIteratorImpl(take(Stream.generate(Random.nextBoolean()))(size))
  }
}
