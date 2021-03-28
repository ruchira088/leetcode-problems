package com.ruchij.problems

object SwapNodesInPairs {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def swapPairs(head: ListNode): ListNode =
    if (head != null && head.next != null) {
      val tail = swapPairs(head.next.next)

      new ListNode(head.next.x, new ListNode(head.x, tail))
    } else head

}
