package ar.com.allentiak.multi_currency_money

import org.scalatest.FunSpec

class MoneyTest extends FunSpec {

  describe("Multi-Currency-enabled Money") {

    it("should support multiplication by a real number") {
      val fiveDollars = Money.dollar(5)
      assert(fiveDollars.times(2) === Money.dollar(10))
      assert(fiveDollars.times(3) === Money.dollar(15))
      val fiveFrancs = new Franc(5)
      assert(fiveFrancs.times(2) === new Franc(10))
      assert(fiveFrancs.times(3) === new Franc(15))
    }

    describe("should support (in)equality") {
      it("internal") {
        assert(Money.dollar(5).equals(Money.dollar(5)))
        assert(new Franc(5).equals(new Franc(5)))
        assert(Money.dollar(5).equals(Money.dollar(6)) === false)
        assert(new Franc(5).equals(new Franc(6)) === false)
      }
      it("external") {
        assert(Money.dollar(5).equals(new Franc(5)) === false)
      }
    }

  }
}
