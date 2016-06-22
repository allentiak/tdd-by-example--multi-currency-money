package ar.com.allentiak.multi_currency_money

import org.scalatest.FunSpec

class MoneyTest extends FunSpec {

  describe("Multi-Currency-enabled Money") {

    it("should support multiplication by a real number") {
      val fiveDollars = Money.dollar(5)
      assert(fiveDollars.times(2) === Money.dollar(10))
      assert(fiveDollars.times(3) === Money.dollar(15))
      val fiveFrancs = Money.franc(5)
      assert(fiveFrancs.times(2) === Money.franc(10))
      assert(fiveFrancs.times(3) === Money.franc(15))
    }

    describe("should support (in)equality") {
      it("internal") {
        assert(Money.dollar(5).equals(Money.dollar(5)))
        assert(Money.franc(5).equals(Money.franc(5)))
        assert(Money.dollar(5).equals(Money.dollar(6)) === false)
        assert(Money.franc(5).equals(Money.franc(6)) === false)
      }
      it("external") {
        assert(Money.dollar(5).equals(Money.franc(5)) === false)
      }
    }

  }
}
