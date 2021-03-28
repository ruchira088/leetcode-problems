package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class CombinationSumTest extends AnyFlatSpec with Matchers {

  "combinationSum" should "return the expected result" in {
    CombinationSum.combinationSum(Array(1), 1) mustBe List(List(1))
    CombinationSum.combinationSum(Array(2), 1) mustBe List()
    CombinationSum.combinationSum(Array(1), 2) mustBe List(List(1, 1))
    CombinationSum.combinationSum(Array(2, 3, 6, 7), 7) mustBe List(List(7), List(2, 2, 3))
  }

  "combinationSumOther" should "return the expected result" in {
    CombinationSum.combinationSumOther(Array(1), 1) mustBe List(List(1))
    CombinationSum.combinationSumOther(Array(2), 1) mustBe List()
    CombinationSum.combinationSumOther(Array(1), 2) mustBe List(List(1, 1))
    CombinationSum.combinationSumOther(Array(2, 3, 6, 7), 7) mustBe List(List(7), List(2, 2, 3))
  }

}
