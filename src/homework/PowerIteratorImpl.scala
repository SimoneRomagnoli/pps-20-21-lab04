package homework

import u04lab.code.{Lists, Optionals, PowerIterator}

case class PowerIteratorImpl[A]() extends PowerIterator[A] {
  override def next(): Optionals.Option[A] = ???

  override def allSoFar(): Lists.List[A] = ???

  override def reversed(): PowerIterator[A] = ???
}
