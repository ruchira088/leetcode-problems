package com.ruchij;

import java.util.Optional;

public class LowestCommonAncestorBinaryTree {
    record TreeNode(int val, TreeNode left, TreeNode right) {}
    record Result(TreeNode common, TreeNode p, TreeNode q) {}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else {
            int value = root.val;

            if (value == p.val() || value == q.val()) {
                return root;
            } else {
                TreeNode left = lowestCommonAncestor(root.left, p, q);
                TreeNode right = lowestCommonAncestor(root.right, p, q);

                if (right == null) {
                    return left;
                } else if (left == null) {
                    return right;
                } else {
                    return root;
                }
            }
        }

    }

    public Result findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, null, null);
        } else {
            int value = root.val;

            if (value == p.val) {
                TreeNode result = findLowestCommonAncestor(root, q);

                if (result != null) {
                    return new Result(root, root, result);
                } else {
                    return new Result(null, root, null);
                }

            } else if (value == q.val) {
                TreeNode result = findLowestCommonAncestor(root, p);

                if (result != null) {
                    return new Result(root, result, root);
                } else {
                    return new Result(null, null, root);
                }
            } else {
                Result left = findLowestCommonAncestor(root.left, p, q);
                Result right = findLowestCommonAncestor(root.right, p, q);

                if (left.common != null) {
                    return left;
                } else if (right.common != null) {
                    return right;
                } else {
                    Optional<TreeNode> pValue = Optional.ofNullable(left.p).or(() -> Optional.ofNullable(right.p));
                    Optional<TreeNode> qValue = Optional.ofNullable(left.q).or(() -> Optional.ofNullable(right.q));

                    if (pValue.isPresent() && qValue.isPresent()) {
                        return new Result(root, pValue.orElse(null), qValue.orElse(null));
                    } else {
                        return new Result(null, pValue.orElse(null), qValue.orElse(null));
                    }
                }
            }
        }
    }

    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        } else {
            if (root.val == p.val) {
                return root;
            } else {
                TreeNode result = findLowestCommonAncestor(root.left, p);

                if (result != null) {
                    return result;
                } else {
                    return findLowestCommonAncestor(root.right, p);
                }
            }
        }
    }
}
