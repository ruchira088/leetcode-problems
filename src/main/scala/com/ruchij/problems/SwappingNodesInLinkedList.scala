package com.ruchij.problems

object SwappingNodesInLinkedList {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x

    def asList: List[Int] =
      if (next == null) List(x) else x :: next.asList
  }

  object ListNode {
    def apply(values: Int*): ListNode =
      values.reverse.foldLeft[ListNode](null) {
        case (acc, value) => new ListNode(value, acc)
      }
  }

  def swapNodes(head: ListNode, k: Int): ListNode = {
    val listLength = length(head)

    val first = getValue(head, k).getOrElse(throw new IllegalArgumentException)
    val second = getValue(head, listLength - k + 1).getOrElse(throw new IllegalArgumentException)

    update(update(head, second, k), first, listLength - k + 1)

//    updateMutable(head, second, k)
//    updateMutable(head, first, listLength - k + 1)
//
//    head
  }

  def length(listNode: ListNode): Int =
    if (listNode == null) 0 else length(listNode.next) + 1

  def getValue(listNode: ListNode, index: Int): Option[Int] =
    if (listNode == null) None
    else if (index == 1) Some(listNode.x)
    else getValue(listNode.next, index - 1)

  def update(listNode: ListNode, value: Int, index: Int): ListNode = {
    if (listNode == null) listNode
    else if (index == 1) new ListNode(value, listNode.next)
    else new ListNode(listNode.x, update(listNode.next, value, index - 1))
  }

  def updateMutable(listNode: ListNode, value: Int, index: Int): ListNode = {
    if (listNode == null) listNode
    else if (index == 1) {
      listNode.x = value
      listNode
    } else updateMutable(listNode.next, value, index - 1)
  }
}
