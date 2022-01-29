package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniversalValueTreeProblemTest {
    private final UniversalValueTreeProblem universalValueTreeProblem = new UniversalValueTreeProblem();

    @Test
    void testOne() {
        UniversalValueTreeProblem.Node<Integer> node = new UniversalValueTreeProblem.Node<>(
                0,
                new UniversalValueTreeProblem.Node<>(1, null, null),
                new UniversalValueTreeProblem.Node<>(0,
                        new UniversalValueTreeProblem.Node<>(
                                2,
                                new UniversalValueTreeProblem.Node<>(2, null, null),
                                new UniversalValueTreeProblem.Node<>(2, null, null)
                        ),
                        new UniversalValueTreeProblem.Node<>(0, null, null)
                )
        );

        Assertions.assertEquals(5, universalValueTreeProblem.univalCount(node));

    }

}