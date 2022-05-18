//Problem: https://leetcode.com/problems/video-stitching/
package com.problem.solutions.leetcode;

import java.util.Arrays;

public class VideoStitch1024 {
    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        int[][] clips = {{0, 1}, {1, 2}};
        int time = 10;
        System.out.println(findMinClips1(clips, time));
        System.out.println(findMinClips2(clips, time));
        System.out.println(findMinClips3(clips, time));

    }

    // DP solution
    private static int findMinClips1(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, time + 100);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int j = 0; j < clips.length; j++) {
                if (clips[j][0] <= i && clips[j][1] >= i) {
                    dp[i] = Math.min(dp[i], dp[clips[j][0]] + 1);
                }
            }
            if (dp[i] >= time + 100) {
                return -1;
            }
        }

        return dp[time];
    }

    //Greedy solution
    private static int findMinClips2(int[][] clips, int time) {
        int min = 0;
        int max = 0;
        int totalClips = 0;
        while (max < time) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < clips.length; i++) {
                left = clips[i][0];
                right = clips[i][1];
                if (left <= min && right > max) {
                    max = right;
                }
            }
            if (min == max) {
                return -1;
            }
            min = max;
            ++totalClips;
        }
        return totalClips;
    }

    //Dp solution similar to the longest increasing subsequence
    private static int findMinClips3(int[][] clips, int time) {
        int max = Integer.MIN_VALUE;
        for (int[] arr : clips) {
            if (arr[1] > max) {
                max = arr[1];
            }
        }
        if (max < time) {
            return -1;
        }
        Arrays.sort(clips, (e1, e2) -> e1[0] - e2[0]);
        int[] dp = new int[clips.length];
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 99999;
            }
        }
        int result = 99999;
        for (int i = 1; i < clips.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int c1End = clips[j][1];
                int c2Start = clips[i][0];
                int c2End = clips[i][1];
                if (c1End >= c2Start && c2End >= c1End) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < clips.length; i++) {
            if (time <= clips[i][1]) {
                result = Math.min(result, dp[i]);
            }
        }
        return result == 99999 ? -1 : result;
    }
}
