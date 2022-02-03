package com.ruchij;

import java.util.ArrayDeque;
import java.util.Objects;

public class StepByStepDirections {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static final class State {
        private final TreeNode treeNode;
        private final String path;

        State(TreeNode treeNode, String path) {
            this.treeNode = treeNode;
            this.path = path;
        }

        public TreeNode treeNode() {
            return treeNode;
        }

        public String path() {
            return path;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return Objects.equals(this.treeNode, that.treeNode) &&
                    Objects.equals(this.path, that.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(treeNode, path);
        }

        @Override
        public String toString() {
            return "State[" +
                    "treeNode=" + treeNode + ", " +
                    "path=" + path + ']';
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        String start = path(root, startValue);
        String end = path(root, destValue);

        String common = commonPrefix(start, end);

        return fill("U", start.substring(common.length()).length()) + end.substring(common.length());
    }

    private String fill(String value, int repeat) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }

    private String commonPrefix(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) {
            return "";
        } else if (first.charAt(0) == second.charAt(0)){
            return first.charAt(0) + commonPrefix(first.substring(1), second.substring(1));
        } else {
            return "";
        }
    }

    private String path(TreeNode root, int target) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(root, ""));

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.treeNode != null) {
                if (target == state.treeNode.val) {
                    return state.path;
                } else {
                    queue.add(new State(state.treeNode.left, state.path + "L"));
                    queue.add(new State(state.treeNode.right, state.path + "R"));
                }
            }
        }

        return null;
    }
}
