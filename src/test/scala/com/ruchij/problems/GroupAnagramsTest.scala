package com.ruchij.problems

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class GroupAnagramsTest extends AnyFlatSpec with Matchers {

  "groupAnagrams" should "return expected result" in {
    GroupAnagrams.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")) mustBe List(
      List("tan", "nat"),
      List("bat"),
      List("eat", "tea", "ate")
    )
    GroupAnagrams.groupAnagrams(Array("")) mustBe List(List(""))
    GroupAnagrams.groupAnagrams(Array("a")) mustBe List(List("a"))
  }

}
