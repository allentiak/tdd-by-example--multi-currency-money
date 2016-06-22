package ar.com.allentiak.multi_currency_money

class Money(protected val amount: Int){
  override def equals(other: Any) = other match {
    case o:Money => {
      (amount == o.amount) &&
      this.getClass.equals(o.getClass)
    }
  }
}

class Dollar(amount: Int) extends Money(amount){
  def times(multiplier: Int) = new Dollar(amount * multiplier)
}

class Franc(amount: Int) extends Money(amount){
  def times(multiplier: Int) = new Franc(amount * multiplier)
}
