package ar.com.allentiak.multi_currency_money

import org.scalatest.FunSpec

class MoneyTest extends FunSpec {

  describe("Multi-Currency-enabled Dollars") {
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

  describe("Multi-Currency-enabled Francs") {
    it("should support multiplication by a real number") {
      val five = new Franc(5)
      assert(five.times(2) === new Franc(10))
      assert(five.times(3) === new Franc(15))
    }
    it("should support equality") {
      assert(new Franc(5).equals(new Franc(5)))
      assertResult(false){
        (new Franc(5).equals(new Franc(6)))
      }
    }
  }

}
