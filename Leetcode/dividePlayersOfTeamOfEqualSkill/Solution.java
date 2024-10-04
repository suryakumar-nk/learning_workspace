package Leetcode.dividePlayersOfTeamOfEqualSkill;

import java.util.Arrays;

public class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long sum = 0;
        long prod = skill[0]+skill[n-1];
        for (int i=0; i<n/2; i++) {
            if (skill[i]+skill[n-1-i] != prod)
                return -1;
            sum += (skill[i]*skill[n-1-i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.dividePlayers(new int[]{3,2,5,3,1,4}));
        // System.out.println(sol.dividePlayers(new int[]{1,1,2,2}));
    }
}