package ar.com.allentiak.multi_currency_money

trait Expression {
  def reduce(bank: Bank, to: String): Money
}

class Sum (val augend: Money, val addend: Money) extends Expression {
  def reduce(bank: Bank, to: String) = new Money(augend.amount + addend.amount, to)
}

class Bank {
  def reduce(source: Expression, to: String): Money = source.reduce(this, to)
  def rate(from: String, to: String): Int =
    (from,to) match {
    case ("USD","CHF") => 2
    case ("USD","USD") => 1
    case _ => 9999 // should be big enough to note it is not defined yet
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
  def plus(addend: Money): Expression = new Sum(this, addend)
  def reduce(myBank: Bank, to: String) = new Money(amount * myBank.rate(this.currency,to), to)
}

object Money {
  def dollar(amount: Int) = new Money(amount, "USD")
  def franc(amount: Int) = new Money(amount, "CHF")
}
