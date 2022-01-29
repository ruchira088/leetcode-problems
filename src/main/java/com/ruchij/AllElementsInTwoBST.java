package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBST {
    record TreeNode(int val, TreeNode left, TreeNode right) {}

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();


        getAllElements(root1, listOne);
        getAllElements(root2, listTwo);

        return mergeOrderedList(listOne, listTwo);
    }

    private void getAllElements(TreeNode treeNode, List<Integer> result) {
        if (treeNode != null) {
            getAllElements(treeNode.left, result);
            result.add(treeNode.val);
            getAllElements(treeNode.right, result);
        }
    }

//    private List<Integer> mergeOrderedList(List<Integer> listOne, List<Integer> listTwo, int indexOne, int indexTwo) {
//        if (indexOne == listOne.size()) {
//            return listTwo.subList(indexTwo, listTwo.size());
//        } else if (indexTwo == listTwo.size()) {
//            return listOne.subList(indexOne, listOne.size());
//        } else {
//            int one = listOne.get(indexOne);
//            int two = listTwo.get(indexTwo);
//
//            List<Integer> integers;
//
//            if (one <= two) {
//                integers = mergeOrderedList(listOne, listTwo, indexOne + 1, indexTwo);
//                integers.add(0, one);
//
//            } else {
//                integers = mergeOrderedList(listOne, listTwo, indexOne, indexTwo + 1);
//                integers.add(0, two);
//            }
//
//            return integers;
//        }
//    }

    private List<Integer> mergeOrderedList(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < listOne.size() || j < listTwo.size()) {
            if (i == listOne.size()) {
                result.addAll(listTwo.subList(j, listTwo.size()));
                return result;
            } else if (j == listTwo.size()) {
                result.addAll(listOne.subList(i, listOne.size()));
                return result;
            } else {
                int one = listOne.get(i);
                int two = listTwo.get(j);

                if (one <= two) {
                    result.add(one);
                    i++;
                } else {
                    result.add(two);
                    j++;
                }
            }
        }

        return result;
    }
}
