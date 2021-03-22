package homework
import u04lab.code.Complex

case class ComplexImpl(re: Double, im: Double) extends Complex {
  override def +(c: Complex): Complex = ComplexImpl(re+c.re, im+c.im)
  override def *(c: Complex): Complex = ComplexImpl(re*c.re-im*c.im, re*c.im+im*c.re)
}


