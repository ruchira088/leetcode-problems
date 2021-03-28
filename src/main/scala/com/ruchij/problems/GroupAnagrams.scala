package com.ruchij.problems

object GroupAnagrams {

  def groupAnagrams(values: Array[String]): List[List[String]] =
    values.toList.groupBy(wordSummary)
      .map {
        case (_, words) => words
      }
      .toList

  private def wordSummary(word: String): Map[Char, Int] =
    word.toList.groupBy(identity)
      .map {
        case (char, values) => char -> values.length
      }

}
