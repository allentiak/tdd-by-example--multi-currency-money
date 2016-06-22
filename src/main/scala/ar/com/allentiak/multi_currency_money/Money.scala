package ar.com.allentiak.multi_currency_money

class Money(protected val amount: Int, val currency: String){
  override def equals(other: Any) = other match {
    case o:Money => {
      (amount == o.amount) &&
      this.currency.equals(o.currency)
    }
  }
  def times(multiplier: Int): Money = new Money(amount * multiplier, currency)
  override def toString: String = amount + " " + currency
  def plus(other:Money) = new Money(amount + other.amount, currency)
}

object Money {
  def dollar(amount: Int) = new Money(amount, "USD")
  def franc(amount: Int) = new Money(amount, "CHF")
}
