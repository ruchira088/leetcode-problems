package com.ruchij;

import java.util.Objects;

public class SerializeDeserializeBinaryTree {
    static final class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val) {
            this(val, null, null);
        }

        public int val() {
            return val;
        }

        public TreeNode left() {
            return left;
        }

        public TreeNode right() {
            return right;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (TreeNode) obj;
            return this.val == that.val &&
                    Objects.equals(this.left, that.left) &&
                    Objects.equals(this.right, that.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        @Override
        public String toString() {
            return "TreeNode[" +
                    "val=" + val + ", " +
                    "left=" + left + ", " +
                    "right=" + right + ']';
        }

    }

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();

            serialize(root, stringBuilder);

            return stringBuilder.toString();
        }

        private void serialize(TreeNode treeNode, StringBuilder stringBuilder) {
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(",");
            }

            if (treeNode == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(treeNode.val);
                serialize(treeNode.left, stringBuilder);
                serialize(treeNode.right, stringBuilder);
            }
        }

        // 1,2,null,null,3,4,null,null,5,null,null

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty() || data.equals("null")) {
                return null;
            } else {
                String[] nodes = data.split(",");
                int index = 0;
                TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
                deserialize(nodes, index, root);

                return root;
            }
        }

        private int deserialize(String[] nodes, int index, TreeNode treeNode) {
            index++;

            if (index < nodes.length) {
                String node = nodes[index];

                if (!node.equals("null")) {
                    treeNode.left = new TreeNode(Integer.parseInt(node));
                    index = deserialize(nodes, index, treeNode.left);
                } else {
                    index++;
                }
            }

            if (index < nodes.length) {
                String node = nodes[index];

                if (!node.equals("null")) {
                    treeNode.right = new TreeNode(Integer.parseInt(node));
                    index = deserialize(nodes, index, treeNode.right);
                } else {
                    index++;
                }
            }

            return index;
        }
    }
}
