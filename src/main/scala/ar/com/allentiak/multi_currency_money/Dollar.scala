package ar.com.allentiak.multi_currency_money

case class Dollar(amount: Int){
  def times(multiplier: Int) = Dollar(amount * multiplier)
}
