package ar.com.allentiak.multi_currency_money
import scala.collection.mutable.HashMap

trait Expression {
  def reduce(bank: Bank, to: String): Money
  def plus(addend: Expression): Expression = new Sum(this, addend)
  def times(multiplier: Double): Expression
}

class Sum (val augend: Expression, val addend: Expression) extends Expression {
  def reduce(bank: Bank, to: String) = new Money(augend.reduce(bank, to).amount + addend.reduce(bank, to).amount, to)
  override def times(multiplier: Double): Expression = new Sum(augend.times(multiplier), addend.times(multiplier))
}

class Bank {
  val rates = new HashMap[Pair,Double]
  def addRate(from: String, to: String, rate: Double) = rates.put(new Pair(from,to), rate)
  def reduce(source: Expression, to: String): Money = source.reduce(this, to)
  def rate(from: String, to: String): Double = if (from.equals(to)) 1 else
  rates.get(new Pair(from, to)) match {
    case None => 0
    case Some(value) => value
    }
  addRate("CHF", "USD", 0.5)
  addRate("USD","CHF", 2)
}

class Pair (val from: String, val to: String) {
  override def equals(o: Any): Boolean = from.equals(o.asInstanceOf[Pair].from) && to.equals(o.asInstanceOf[Pair].to)
  override def hashCode: Int = 0
}

class Money (val amount: Double, val currency: String) extends Expression {
  override def equals(other: Any) = other match {
    case o:Money => {
      (amount == o.amount) &&
      this.currency.equals(o.currency)
    }
    case _ => false
  }
  def times(multiplier: Double): Expression = new Money(amount * multiplier, currency)
  override def toString: String = amount + " " + currency
  override def plus(addend: Expression): Expression = new Sum(this, addend)
  def reduce(myBank: Bank, to: String) = new Money(amount * myBank.rate(this.currency,to), to)
}

object Money {
  def dollar(amount: Double) = new Money(amount, "USD")
  def franc(amount: Double) = new Money(amount, "CHF")
}
