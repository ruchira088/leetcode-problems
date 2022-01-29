package com.ruchij;

public class UniversalValueTreeProblem {
    record Node<A>(A value, Node<A> left, Node<A> right) {}
    record Result<A>(A value, int count, boolean success) {}

    public int univalCount(Node<?> node) {
        return count(node).count;
    }

    private <A> Result<A> count(Node<A> node) {
        if (node == null) {
            return new Result<>(null, 0, true);
        } else {
            Result<A> leftResult = count(node.left);
            Result<A> rightResult = count(node.right);

            int total = leftResult.count + rightResult.count;

            if (leftResult.success && rightResult.success) {
                if (leftResult.value == null && rightResult.value == null) {
                    return new Result<>(node.value, total + 1, true);
                } else if (leftResult.value == rightResult.value && rightResult.value == node.value){
                    return new Result<>(node.value, total + 1, true);
                }
            }

            return new Result<>(node.value, total, false);
        }
    }
}
