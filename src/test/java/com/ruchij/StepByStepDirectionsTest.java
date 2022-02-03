package com.ruchij;

import org.junit.jupiter.api.Test;

class StepByStepDirectionsTest {
    private final StepByStepDirections stepByStepDirections = new StepByStepDirections();

    @Test
    void testOne() {
        StepByStepDirections.TreeNode treeNode =
                new StepByStepDirections.TreeNode(
                        5,
                        new StepByStepDirections.TreeNode(1,
                                new StepByStepDirections.TreeNode(3),
                                new StepByStepDirections.TreeNode(7)
                        ),
                        new StepByStepDirections.TreeNode(2,
                                new StepByStepDirections.TreeNode(6),
                                new StepByStepDirections.TreeNode(4)
                        )
                );

        System.out.println(stepByStepDirections.getDirections(treeNode, 3, 6));
    }

    @Test
    void testTwo() {
        StepByStepDirections.TreeNode treeNode =
                new StepByStepDirections.TreeNode(
                        2,
                        new StepByStepDirections.TreeNode(1),
                        null
                );

        System.out.println(stepByStepDirections.getDirections(treeNode, 2, 1));
    }

}