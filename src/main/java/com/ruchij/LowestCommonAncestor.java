package com.ruchij;

public class LowestCommonAncestor {
    record Node(int val, Node left, Node right, Node parent) {}
    record Result(int level, Node node){}

    public Node lowestCommonAncestor(Node p, Node q) {
        if (find(p, q.val) != null) {
            return p;
        } else if (find(q, p.val) != null) {
            return q;
        } else {
            return findParent(p, q.val);
        }
    }

    Node findParent(Node node, int target) {
        Node parent = node.parent;
        Node result = null;

        if (parent.left != null && parent.left.val == node.val) {
            result = find(parent.right, target);
        } else {
            result = find(parent.left, target);
        }

        if (result != null) {
            return parent;
        } else {
            return findParent(parent, target);
        }

    }

    Node find(Node node, int target) {
        if (node == null) {
            return null;
        } else {
            if (node.val == target) {
                return node;
            } else {
                Node left = find(node.left, target);

                if (left != null) {
                    return left;
                } else {
                    return find(node.right, target);
                }
            }
        }
    }
}
