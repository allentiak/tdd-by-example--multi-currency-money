package ar.com.allentiak.multi_currency_money

class Dollar(val amount: Int){
  def times(multiplier: Int) = new Dollar(amount * multiplier)
  override def equals(other: Any) = other match {
    case o:Dollar => amount == o.amount
  }
}
