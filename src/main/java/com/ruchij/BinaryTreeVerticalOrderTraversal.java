package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    record State(int index, TreeNode treeNode) {}

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        ArrayDeque<State> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(new State(0, root));

        while (!arrayDeque.isEmpty()) {
            State state = arrayDeque.pop();

            if (state.treeNode != null) {
                List<Integer> values = result.getOrDefault(state.index, new ArrayList<>());
                values.add(state.treeNode.val);
                result.put(state.index, values);

                arrayDeque.add(new State(state.index - 1, state.treeNode.left));
                arrayDeque.add(new State(state.index + 1, state.treeNode.right));
            }
        }

        return result.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
