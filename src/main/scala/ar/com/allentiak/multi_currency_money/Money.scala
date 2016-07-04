package ar.com.allentiak.multi_currency_money

trait Expression {
  def reduce(bank: Bank, to: String): Money
}

class Sum (val augend: Money, val addend: Money) extends Expression {
  def reduce(bank: Bank, to: String) = new Money(augend.amount + addend.amount, to)
}

class Bank {
  def reduce(source: Expression, to: String): Money = source.reduce(this, to)
  def rate(from: String, to: String): Double =
    (from,to) match {
    case ("USD","CHF") => 2.0
    case ("CHF","USD") => 0.5
    case ("CHF","CHF") => 1.0
    case ("USD","USD") => 1.0
  }
}

private class Pair (val from: String, val to: String) {
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
  def times(multiplier: Double): Money = new Money(amount * multiplier, currency)
  override def toString: String = amount + " " + currency
  def plus(addend: Money): Expression = new Sum(this, addend)
  def reduce(myBank: Bank, to: String) = new Money(amount * myBank.rate(this.currency,to), to)
}

object Money {
  def dollar(amount: Double) = new Money(amount, "USD")
  def franc(amount: Double) = new Money(amount, "CHF")
}
