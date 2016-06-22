package ar.com.allentiak.multi_currency_money

trait Expression

class Bank {
  def reduce(source: Expression, to: String): Money = null
}

class Money(protected val amount: Int, val currency: String) extends Expression {
  override def equals(other: Any) = other match {
    case o:Money => {
      (amount == o.amount) &&
      this.currency.equals(o.currency)
    }
    case _ => false
  }
  def times(multiplier: Int): Money = new Money(amount * multiplier, currency)
  override def toString: String = amount + " " + currency
  def plus(other:Money): Expression = new Money(amount + other.amount, currency)
}

object Money {
  def dollar(amount: Int) = new Money(amount, "USD")
  def franc(amount: Int) = new Money(amount, "CHF")
}
