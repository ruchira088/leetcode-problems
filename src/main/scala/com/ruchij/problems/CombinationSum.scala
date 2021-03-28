package com.ruchij.problems

import scala.annotation.tailrec

object CombinationSum {

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] =
    if (target == 0) List(List.empty)
    else if (target < 0) List.empty
    else {
      candidates.headOption.toList.flatMap { value =>
        List
          .range(0, target / value + 1)
          .flatMap { count =>
            val combination = List.fill(count)(value)

            combinationSum(candidates.tail, target - combination.sum)
              .map { result =>
                combination ++ result
              }
          }
      }
    }

  case class Node(target: Int, candidates: List[Int], history: List[Int])

  def combinationSumOther(candidates: Array[Int], target: Int): List[List[Int]] =
    combinationSumOther(List(Node(target, candidates.toList, List.empty)), List.empty)
      .map(_.history)

  @tailrec
  private def combinationSumOther(nodes: List[Node], result: List[Node]): List[Node] =
    nodes match {
      case Nil => result

      case node :: tail =>
        if (node.target == 0) combinationSumOther(tail, node :: result)
        else if (node.target < 0) combinationSumOther(tail, result)
        else
          combinationSumOther(
            tail ++ node.candidates.headOption.toList.flatMap { candidate =>
              List
                .range(0, node.target / candidate + 1)
                .map { count =>
                  val values = List.fill(count)(candidate)

                  Node(node.target - values.sum, node.candidates.tail, node.history ++ values)
                }
            },
            result
          )

    }
}
