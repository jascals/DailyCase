package com.jascal.alogtest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ihave4cat
 * <p>日常刷题</p>
 * @data on 2021/4/22 3:33 PM
 * @email jascal@163.com
 */
public class DailyCase {

    /**
     * 1017. Convert to Base -2
     *
     * @param n input
     * @return String output
     */
    public String convertToBaseNegativeTwo(int n) {
        StringBuilder result = new StringBuilder();
        int base = -2;
        if (n == 0)
            return "0";
        while (n != 0) {
            int i = n % base;
            n /= base;
            if (i < 0) {
                i += Math.abs(base);
                n++;
            }
            result.insert(0, i);
        }
        return result.toString();
    }

    /**
     * 205. Isomorphic Strings
     *
     * @param m input
     * @param n input
     * @return String output
     */
    public boolean isomorphicStrings(String m, String n) {
        if (m.length() == 1) {
            return true;
        }
        return isomorphicStringsInternal(m, n) && isomorphicStringsInternal(n, m);
    }

    public boolean isomorphicStringsInternal(String m, String n) {
        boolean result = true;
        Map<String, String> targetMap = new HashMap<>();
        for (int i = 0; i < m.length(); i++) {
            String prefix = String.valueOf(m.charAt(i));
            String postfix = String.valueOf(n.charAt(i));
            if (!targetMap.containsKey(prefix)) {
                targetMap.put(prefix, postfix);
            }
            result = result && targetMap.get(prefix).equals(postfix);
        }
        return result;
    }

    /**
     * 70. Climbing Stairs
     *
     * @param n stairs
     * @return ways ways
     */
    public int climbingStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i <= n - 1; i++) {
            a[i] = a[i - 2] + a[i - 1];
        }
        return a[n - 1];
    }

    /**
     * 11. Container With Most Water
     *
     * @param height height-values array
     * @return maxArea
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i]);
                i++;
            } else {
                max = Math.max(max, (j - i) * height[j]);
                j--;
            }
        }
        return max;
    }

    /**
     * 64. Minimum Path Sum
     *
     * @param grid nums
     * @return sum
     */
    public int minimumPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j] + grid[i][j], res[i][j - 1] + grid[i][j]);
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     * 91. Decode Ways
     *
     * @param s input
     * @return ways
     */
    public int decodeWays(String s) {
        char[] chars = s.toCharArray();

        if (chars[0] == '0') {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '1' || chars[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }

        return dp[len];
    }

    /**
     * 199. Binary Tree Right Side View
     *
     * @param root root
     * @return List<Integer>
     */
    public List<Integer> binaryTreeRightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.removeFirst();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }

        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1014. Best Sightseeing Pair
     *
     * @param values values
     * @return res
     */
    public int bestSightseeingPair(int[] values) {
        int max = values[0];
        int i = 1;
        int ans = max;
        while (i < values.length) {
            ans = Math.max(ans, max + values[i] - i);
            max = Math.max(max, values[i] + i);
            i++;
        }
        return ans;
    }

    /**
     * 459. Repeated Substring Pattern
     * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
     *
     * @param s input
     * @return res
     */
    public boolean repeatedSubstringPattern(String s) {
        String str1 = s.substring(1);
        String str2 = s.substring(0, s.length() - 1);
        return (s.substring(1) + s.substring(0, s.length() - 1)).contains(s);
    }

    /**
     * 167. Two Sum II - Input array is sorted
     *
     * @param numbers number list
     * @param target  target number
     * @return indexs
     */
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        while (a < b) {
            if (numbers[a] + numbers[b] > target) {
                b--;
            } else if (numbers[a] + numbers[b] < target) {
                a++;
            } else {
                return new int[]{a + 1, b + 1};
            }

        }
        return new int[2];
    }

    /**
     * 400. Nth Digit
     *
     * @param n nth number
     * @return int value
     */
    public int findNthDigit(int n) {
        long digitCounts = 9;
        int digitLength = 1;
        int digitStart = 1;
        while (n > digitLength * digitCounts) {
            n -= digitLength * digitCounts;
            digitLength++;
            digitCounts *= 10;
            digitStart *= 10;
        }
        String numStr = Integer.toString(digitStart + (n - 1) / digitLength);
        return Integer.decode(String.valueOf(numStr.charAt((n - 1) % digitLength)));
    }

    /**
     * 977. Squares of a Sorted Array
     *
     * @param nums nums array
     * @return sorted array
     */
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while (i < j) {
            if (pow(nums[i]) < pow(nums[j])) {
                result[index] = pow(nums[j]);
                j--;
            } else {
                result[index] = pow(nums[i]);
                i++;
            }
            index--;
        }
        result[index] = pow(nums[i]);
        return result;
    }

    private int pow(int n) {
        return n * n;
    }
}
