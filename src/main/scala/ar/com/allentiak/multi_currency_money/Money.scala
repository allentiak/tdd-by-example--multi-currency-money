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
}

object Money {
  def dollar(amount: Int): Money = new Dollar(amount, "USD")
  def franc(amount: Int): Money = new Franc(amount, "CHF")
}

class Dollar(amount: Int, currency: String) extends Money(amount, currency)

class Franc(amount: Int, currency: String) extends Money(amount, currency)
