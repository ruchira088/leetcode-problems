package com.ruchij.problems

object FirstMissingPositive {

  def firstMissingPositive(nums: Array[Int]): Int = {
    val numbersSet = nums.toSet

    Range.inclusive(1, nums.length)
      .find(number => !numbersSet.contains(number))
      .getOrElse(nums.length + 1)
  }

}
