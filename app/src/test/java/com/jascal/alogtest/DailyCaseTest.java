package com.jascal.alogtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author ihave4cat
 * @data on 2021/4/22 3:34 PM
 * @email jascal@163.com
 */
public class DailyCaseTest {
    private DailyCase dailyCase;

    @Before
    public void setUp() {
        dailyCase = new DailyCase();
    }

    @Test
    public void testConvertToBaseNegativeTwo() {
        Assert.assertEquals("110", dailyCase.convertToBaseNegativeTwo(2));
        Assert.assertEquals("111", dailyCase.convertToBaseNegativeTwo(3));
        Assert.assertEquals("100", dailyCase.convertToBaseNegativeTwo(4));
    }

    @Test
    public void testIsomorphicStrings() {
        Assert.assertTrue(dailyCase.isomorphicStrings("egg", "add"));
        Assert.assertFalse(dailyCase.isomorphicStrings("egg", "who"));
        Assert.assertFalse(dailyCase.isomorphicStrings("badc", "baba"));
        Assert.assertFalse(dailyCase.isomorphicStrings("abca", "abaa"));
        Assert.assertFalse(dailyCase.isomorphicStrings("aaeaa", "uuxyy"));
    }

    @Test
    public void testIsomorphicStringsInternal() {
        Assert.assertFalse(dailyCase.isomorphicStringsInternal("aaeaa", "uuxyy"));
        Assert.assertTrue(dailyCase.isomorphicStringsInternal("uuxyy", "aaeaa"));
    }

    @Test
    public void testClimbingStairs() {
        Assert.assertEquals(2, dailyCase.climbingStairs(2));
    }

    @Test
    public void testMaxArea() {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7, 1, 1};
        Assert.assertEquals(49, dailyCase.maxArea(a));
        int[] b = {1, 2, 4, 3};
        Assert.assertEquals(4, dailyCase.maxArea(b));
    }

    @Test
    public void testMinimumPathSum() {
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Assert.assertEquals(7, dailyCase.minimumPathSum(a));
        int[][] b = {{1, 2, 3}, {4, 5, 6}};
        Assert.assertEquals(12, dailyCase.minimumPathSum(b));
    }

    @Test
    public void testDecodeWays() {
        String example1 = "226";
        Assert.assertEquals(3, dailyCase.decodeWays(example1));
        String example2 = "10";
        Assert.assertEquals(1, dailyCase.decodeWays(example2));
    }

    @Test
    public void testBinaryTreeRightSideView() {
        DailyCase.TreeNode root = new DailyCase.TreeNode(1);
        root.left = new DailyCase.TreeNode(2);
        root.left.right = new DailyCase.TreeNode(5);
        root.right = new DailyCase.TreeNode(3);
        root.right.right = new DailyCase.TreeNode(4);
        List<Integer> res = dailyCase.binaryTreeRightSideView(root);
        Assert.assertEquals(1, res.get(0).intValue());
        Assert.assertEquals(3, res.get(1).intValue());
        Assert.assertEquals(4, res.get(2).intValue());
    }

    @Test
    public void testBestSightseeingPair() {
        Assert.assertEquals(11, dailyCase.bestSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        Assert.assertEquals(18, dailyCase.bestSightseeingPair(new int[]{6,9,10,5,9,10,4,5}));
    }

    @Test
    public void testRepeatedSubstringPattern() {
        Assert.assertTrue(dailyCase.repeatedSubstringPattern("abcabc"));
        Assert.assertFalse(dailyCase.repeatedSubstringPattern("abcab"));
        Assert.assertTrue(dailyCase.repeatedSubstringPattern("accaccacc"));
    }
}