package main.java.com.yuda.train;

import java.util.*;

/**
 * @author canyu
 * @create_date 2021/2/26 8:39
 */
public class Solution1178 {
    /**
     * 超时版本
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>(puzzles.length);
        // 得到谜底
        List<Set<Integer>> wordsList = new ArrayList<>();
        for (String word : words) {
            Set<Integer> wordSet = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i);
                wordSet.add(c);
            }
            wordsList.add(wordSet);
        }

        for (String puzzle : puzzles) {
            int count = findCount(wordsList, puzzle);
            result.add(count);
        }
        return result;
    }

    private int findCount(List<Set<Integer>> wordsList, String puzzle) {
        int result = 0;
        Set<Integer> puzzleSet = new HashSet<>();
        for (int i = 0; i < puzzle.length(); i++) {
            int c = puzzle.charAt(i);
            puzzleSet.add(c);
        }
        for (Set<Integer> integers : wordsList) {
            int must = puzzle.charAt(0);
            if (integers.contains(must)) {
                boolean flag = true;
                for (Integer wordChar : integers) {
                    if (!puzzleSet.contains(wordChar)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 官方题解
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;

            // 枚举子集方法一
            // for (int choose = 0; choose < (1 << 6); ++choose) {
            //     int mask = 0;
            //     for (int i = 0; i < 6; ++i) {
            //         if ((choose & (1 << i)) != 0) {
            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
            //         }
            //     }
            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
            //     if (frequency.containsKey(mask)) {
            //         total += frequency.get(mask);
            //     }
            // }

            // 枚举子集方法二
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }
        return ans;
    }

}
