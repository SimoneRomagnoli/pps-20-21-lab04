package homework

import u04lab.code.{Lists, Optionals, PowerIterator}
import u04lab.code.Optionals.Option
import u04lab.code.Lists.List
import u04lab.code.Lists.List._
import u04lab.code.Streams.Stream
import u04lab.code.Streams.Stream._

case class PowerIteratorImpl[A](var stream: Stream[A] = Empty()) extends PowerIterator[A] {
  private var pastList:List[A] = Nil()

  override def next(): Optionals.Option[A] = stream match {
    case Stream.Cons(h, t) =>
      pastList = append(pastList, List.Cons(h, Nil()))
      stream = t()
      Option.Some(h())
    case _ => Option.empty
  }

  override def allSoFar(): Lists.List[A] = pastList

  override def reversed(): PowerIterator[A] = PowerIteratorImpl(toStream(reverse(pastList)))
}
