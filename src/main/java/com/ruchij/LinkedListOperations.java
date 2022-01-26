package com.ruchij;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedListOperations {
    static final class MyLinkedList<A> {
        private A value;
        private MyLinkedList<A> next;

        MyLinkedList(A value, MyLinkedList<A> next) {
            this.value = value;
            this.next = next;
        }

        public A value() {
            return value;
        }

        public MyLinkedList<A> next() {
            return next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (MyLinkedList) obj;
            return Objects.equals(this.value, that.value) &&
                    Objects.equals(this.next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            return "MyLinkedList[" +
                    "value=" + value + ", " +
                    "next=" + next + ']';
        }
    }

    <A> MyLinkedList<A> reverse(MyLinkedList<A> list) {
        MyLinkedList<A> result = null;

        while (list != null) {
            result = new MyLinkedList<>(list.value, result);
            list = list.next;
        }

        return result;
    }

    <A> MyLinkedList<A> cloneRecursive(MyLinkedList<A> list) {
        if (list == null) {
            return null;
        } else {
            return new MyLinkedList<>(list.value, cloneRecursive(list.next));
        }
    }

    <A> MyLinkedList<A> clone(MyLinkedList<A> list) {
        MyLinkedList<A> head = null;
        MyLinkedList<A> last = null;

        while (list != null) {
            if (head == null) {
                head = new MyLinkedList<>(list.value, null);
                last = head;
            } else {
                last.next = new MyLinkedList<>(list.value, null);
                last = last.next;
            }

            list = list.next;
        }

        return head;
    }

    <A> ArrayList<A> toList(MyLinkedList<A> list) {
        ArrayList<A> result = new ArrayList<>();

        while (list != null) {
            result.add(list.value);
            list = list.next;
        }

        return result;
    }

    <A> MyLinkedList<A> fromList(List<A> list) {
        MyLinkedList<A> head = null;
        MyLinkedList<A> last = null;

        for (A element: list) {
            if (head == null) {
                head = new MyLinkedList<>(element, null);
                last = head;
            } else {
                last.next = new MyLinkedList<>(element, null);
                last = last.next;
            }
        }

        return head;
    }
}
