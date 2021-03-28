package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class PhoneNumberLetterCombinationsTest extends AnyFlatSpec with Matchers {

  "letterCombinations" should "return expected result" in {
    PhoneNumberLetterCombinations.letterCombinations("23") mustBe List(
      "ad",
      "ae",
      "af",
      "bd",
      "be",
      "bf",
      "cd",
      "ce",
      "cf"
    )
    PhoneNumberLetterCombinations.letterCombinations("") mustBe List.empty
    PhoneNumberLetterCombinations.letterCombinations("2") mustBe List("a", "b", "c")
  }

}
