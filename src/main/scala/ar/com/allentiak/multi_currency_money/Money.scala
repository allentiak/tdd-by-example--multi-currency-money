package ar.com.allentiak.multi_currency_money

class Money(protected val amount:Int){
  override def equals(other: Any) = other match {
    case o:Dollar => amount == o.amount
    }
}

class Dollar(amount:Int) extends Money(amount){
  def times(multiplier: Int) = new Dollar(amount * multiplier)
}

class Franc(amount:Int) extends Money(amount){
  def times(multiplier: Int) = new Franc(amount * multiplier)
}
