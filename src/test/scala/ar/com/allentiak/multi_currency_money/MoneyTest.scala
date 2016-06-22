package ar.com.allentiak.multi_currency_money

import org.scalatest.FunSpec

class MoneyTest extends FunSpec {
  describe("Multi-Currency Money") {
    it("should support multiplication by a real number") {
      val five = Dollar(5)
      assert(five.times(2).amount === 10)
      assert(five.times(3).amount === 15)
    }
    it("should support equality") {
      assert(Dollar(5).equals(Dollar(5)))
    }
  }
}
