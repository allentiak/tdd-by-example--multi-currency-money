package ar.com.allentiak.multi_currency_money

class Dollar(private val amount: Int){
  def times(multiplier: Int) = new Dollar(amount * multiplier)
  override def equals(other: Any) = other match {
    case o:Dollar => amount == o.amount
  }
}

class Franc(private val amount: Int){
  def times(multiplier: Int) = new Franc(amount * multiplier)
  override def equals(other: Any) = other match {
    case o:Franc => amount == o.amount
  }
}
