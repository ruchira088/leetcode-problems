package com.ruchij.problems

object PhoneNumberLetterCombinations {
  val NumberMappings: Map[Int, List[Char]] =
    Map(
      2 -> List('a', 'b', 'c'),
      3 -> List('d', 'e', 'f'),
      4 -> List('g', 'h', 'i'),
      5 -> List('j', 'k', 'l'),
      6 -> List('m', 'n', 'o'),
      7 -> List('p', 'q', 'r', 's'),
      8 -> List('t', 'u', 'v'),
      9 -> List('w', 'x', 'y', 'z')
    )

  def letterCombinations(digits: String): List[String] = {
    digits.headOption.map(_.toString) match {
      case Some(value) =>
        val rest = if (digits.tail.isEmpty) List("") else letterCombinations(digits.tail)

        NumberMappings.getOrElse(value.toIntOption.getOrElse(0), List.empty)
          .flatMap {
            char => rest.map(char.toString + _)
          }

      case _ => List.empty
    }
  }
}
