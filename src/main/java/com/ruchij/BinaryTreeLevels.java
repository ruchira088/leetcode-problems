package com.ruchij;

import java.util.*;

public class BinaryTreeLevels {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    static final class State {
        private final int level;
        private final TreeNode treeNode;

        State(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }

        public int level() {
            return level;
        }

        public TreeNode treeNode() {
            return treeNode;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return this.level == that.level &&
                    Objects.equals(this.treeNode, that.treeNode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, treeNode);
        }

        @Override
        public String toString() {
            return "State[" +
                    "level=" + level + ", " +
                    "treeNode=" + treeNode + ']';
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        int currentLevel = 0;

        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(currentLevel, root));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.treeNode != null) {
                if (currentLevel == state.level) {
                    level.add(state.treeNode.val);
                } else {
                    currentLevel++;
                    result.add(level);

                    level = new ArrayList<>();
                    level.add(state.treeNode.val);
                }

                queue.add(new State(state.level + 1, state.treeNode.left));
                queue.add(new State(state.level + 1, state.treeNode.right));
            }
        }

        if (!level.isEmpty()) {
            result.add(level);
        }
        return result;
    }

}
