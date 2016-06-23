package ar.com.allentiak.multi_currency_money

trait Expression

class Sum (val augend: Money, val addend: Money) extends Expression {
  def reduce(to: String) = new Money(augend.amount + addend.amount, to)
}

class Bank {
  def reduce(source: Expression, to: String): Money = {
    val sum = source.asInstanceOf[Sum]
    sum.reduce(to)
  }
}

class Money (val amount: Int, val currency: String) extends Expression {
  override def equals(other: Any) = other match {
    case o:Money => {
      (amount == o.amount) &&
      this.currency.equals(o.currency)
    }
    case _ => false
  }
  def times(multiplier: Int): Money = new Money(amount * multiplier, currency)
  override def toString: String = amount + " " + currency
  def plus(addend:Money): Expression = new Sum(this, addend)
}

object Money {
  def dollar(amount: Int) = new Money(amount, "USD")
  def franc(amount: Int) = new Money(amount, "CHF")
}
