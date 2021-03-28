package com.ruchij.problems

import com.ruchij.problems.SwappingNodesInLinkedList.ListNode
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class SwappingNodesInLinkedListTest extends AnyFlatSpec with Matchers {

  "length" should "return the length of the ListNode" in {
    SwappingNodesInLinkedList.length(ListNode(1, 2, 3, 4, 5)) mustBe 5
    SwappingNodesInLinkedList.length(ListNode()) mustBe 0
  }

  "getValue" should "return the value at the index" in {
    SwappingNodesInLinkedList.getValue(ListNode(1, 2, 3, 4, 5), 3) mustBe Some(3)
    SwappingNodesInLinkedList.getValue(ListNode(1, 2, 3, 4, 5), 6) mustBe None
  }

  "update" should "update the value at the index" in {
    SwappingNodesInLinkedList.update(ListNode(1, 2, 3, 4, 5), 0, 3).asList mustBe List(1, 2, 0, 4, 5)
  }

  "swapNodes" should "swap the node values" in {
    SwappingNodesInLinkedList.swapNodes(ListNode(1, 2, 3, 4, 5), 2).asList mustBe List(1, 4, 3, 2, 5)
    SwappingNodesInLinkedList.swapNodes(ListNode(7, 9, 6, 6, 7, 8, 3, 0, 9, 5), 5).asList mustBe List(7, 9, 6, 6, 8, 7,
      3, 0, 9, 5)
    SwappingNodesInLinkedList.swapNodes(ListNode(1), 1).asList mustBe List(1)
    SwappingNodesInLinkedList.swapNodes(ListNode(1, 2), 1).asList mustBe List(2, 1)
    SwappingNodesInLinkedList.swapNodes(ListNode(1, 2, 3), 2).asList mustBe List(1, 2, 3)
  }

}
