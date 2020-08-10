//Problem: https://leetcode.com/problems/video-stitching/
package com.problem.solutions.leetcode;

import java.util.Arrays;

public class VideoStitch {
    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        int[][] clips = {{0, 1}, {1, 2}};
        int time = 10;
        System.out.println(findMinClips1(clips, time));
        System.out.println(findMinClips2(clips, time));

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
}
