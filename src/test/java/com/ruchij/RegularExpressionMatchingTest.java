package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegularExpressionMatchingTest {
    private final RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();

    @Test
    void parsePattern() {
        Assertions.assertEquals(
                List.of(
                        new RegularExpressionMatching.Character('a'),
                        new RegularExpressionMatching.Character('a'),
                        new RegularExpressionMatching.Character('a')
                ),
                regularExpressionMatching.parse("aaa")
        );

        Assertions.assertEquals(
                List.of(
                        new RegularExpressionMatching.ZeroOrMore(new RegularExpressionMatching.Character('a')),
                        new RegularExpressionMatching.Character('a')
                ),
                regularExpressionMatching.parse("a*a")
        );

        Assertions.assertEquals(
                List.of(
                        new RegularExpressionMatching.ZeroOrMore(new RegularExpressionMatching.Character('a')),
                        new RegularExpressionMatching.Character('b')
                ),
                regularExpressionMatching.parse("a*a*a*a*a*a*a*a*a*a*a*a*b")
        );

    }

    @Test
    void solve() {
//        Assertions.assertFalse(regularExpressionMatching.isMatch("aa", "a"));
//        Assertions.assertTrue(regularExpressionMatching.isMatch("aa", "a*"));
//        Assertions.assertTrue(regularExpressionMatching.isMatch("ab", ".*"));
//        Assertions.assertTrue(regularExpressionMatching.isMatch("aab", "c*a*b"));
        Assertions.assertTrue(regularExpressionMatching.isMatch("a", "ab*"));
    }

}
