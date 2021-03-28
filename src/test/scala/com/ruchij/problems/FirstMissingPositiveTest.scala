package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class FirstMissingPositiveTest extends AnyFlatSpec with Matchers {

  "firstMissingPositive" should "return expected result" in {
    FirstMissingPositive.firstMissingPositive(Array(1, 2, 0)) mustBe 3
    FirstMissingPositive.firstMissingPositive(Array(3, 4, -1, 1)) mustBe 2
    FirstMissingPositive.firstMissingPositive(Array(7, 8, 9, 11, 12)) mustBe 1
  }

}
