package ar.com.allentiak.multi_currency_money

import org.scalatest.FunSpec

class MoneyTest extends FunSpec {
  describe("Multi-Currency Money") {
    it("should support multiplication by a real number") {
      val five = new Dollar(5)
      assert(five.times(2) === new Dollar(10))
      assert(five.times(3) === new Dollar(15))
    }
    it("should support equality") {
      assert(new Dollar(5).equals(new Dollar(5)))
      assertResult(false){
        (new Dollar(5).equals(new Dollar(6)))
      }
    }
  }
}
