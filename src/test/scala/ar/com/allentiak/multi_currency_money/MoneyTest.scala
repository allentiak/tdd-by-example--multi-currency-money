package ar.com.allentiak.multi_currency_money

import org.scalatest.FunSpec

class MoneyTest extends FunSpec {

  describe("Multi-Currency-enabled Money") {

    it("should support multiplication by a real number") {
      val fiveDollars = new Dollar(5)
      assert(fiveDollars.times(2) === new Dollar(10))
      assert(fiveDollars.times(3) === new Dollar(15))
      val fiveFrancs = new Franc(5)
      assert(fiveFrancs.times(2) === new Franc(10))
      assert(fiveFrancs.times(3) === new Franc(15))
    }

    describe("should support equality") {
      it("internal") {
        assert(new Dollar(5).equals(new Dollar(5)))
        assert(new Franc(5).equals(new Franc(5)))
        assert(new Dollar(5).equals(new Dollar(6)) === false)
        assert(new Franc(5).equals(new Franc(6)) === false)
      }
      it("external") {
        assert(new Dollar(5).equals(new Franc(5)) === false)
      }
    }

  }
}
