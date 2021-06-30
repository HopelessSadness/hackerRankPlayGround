package com.hackerrRank;

import java.util.*;

public class ClimbingTheLeaderboard {
    private static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> outputList = new ArrayList<>(player.size());

        Set<Integer> rankedSet = new LinkedHashSet<>();
        for (int i = ranked.size(); i > 0; i--) rankedSet.add(ranked.get(i - 1));

        Integer[] rankedWithoutDuplicates = new Integer[rankedSet.size()];
        rankedSet.toArray(rankedWithoutDuplicates);

        for (int i = 0; i < player.size(); i++) {
            int position = Arrays.binarySearch(rankedWithoutDuplicates, player.get(i));
            if (position >= 0) {
                outputList.add(rankedWithoutDuplicates.length - position);
            } else {
                outputList.add(rankedWithoutDuplicates.length - Math.abs(position) + 2);
            }
        }

        return outputList;
    }

    public static void main(String[] args) {
        Integer[] ranked = new Integer[]{
                Integer.parseInt("100"),
                Integer.parseInt("90"),
                Integer.parseInt("90"),
                Integer.parseInt("80"),
                Integer.parseInt("75"),
                Integer.parseInt("60"),
                Integer.parseInt("50")
        };

        Integer[] player = new Integer[]{
                Integer.parseInt("50"),
                Integer.parseInt("50"),
                Integer.parseInt("50"),
                Integer.parseInt("65"),
                Integer.parseInt("77"),
                Integer.parseInt("90"),
                Integer.parseInt("102")
        };

        List<Integer> rankedList = Arrays.asList(ranked);
        List<Integer> playerList = Arrays.asList(player);
    }
}