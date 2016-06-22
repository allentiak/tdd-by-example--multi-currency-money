package ar.com.allentiak.multi_currency_money

class Dollar(val amount: Int){
  def times(multiplier: Int) = new Dollar(amount * multiplier)
}
