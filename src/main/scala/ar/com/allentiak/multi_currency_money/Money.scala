package ar.com.allentiak.multi_currency_money

abstract class Money(protected val amount: Int){
  override def equals(other: Any) = other match {
    case o:Money => {
      (amount == o.amount) &&
      this.getClass.equals(o.getClass)
    }
  }
  def times(multiplier: Int): Money
  def currency: String
}

object Money {
  def dollar(amount: Int): Money = new Dollar(amount)
  def franc(amount: Int): Money = new Franc(amount)
}

class Dollar(amount: Int) extends Money(amount){
  def times(multiplier: Int): Money = new Dollar(amount * multiplier)
  def currency = "USD"
}

class Franc(amount: Int) extends Money(amount){
  def times(multiplier: Int): Money = new Franc(amount * multiplier)
  def currency = "CHF"
}
