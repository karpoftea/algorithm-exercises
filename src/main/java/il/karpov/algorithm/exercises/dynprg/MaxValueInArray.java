package il.karpov.algorithm.exercises.dynprg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Imagine you are a professional thief and you’ve broken into an art museum.
 * The security will only go off if adjacent paintings are taken off a wall.
 * Given an array of numbers representing the value of each painting
 * determine the maximum value of stolen paintings.
 * In the following array of painting values: [3,5,6,2,1,8],
 * the maximum heist value would be from 3,6,8 for a total of 17.
 *
 * <p>Original problem from <a href="https://medium.com/dataseries/learning-dynamic-programming-with-a-popular-coding-interview-question-5a5c0170fa44">medium post</a></p>
 */
public class MaxValueInArray {

    private List<Integer> maxSeq = Collections.emptyList();

    public List<Integer> findMaxStolenValue(int[] paintingValues) {
        if (paintingValues.length < 3) return maxSeq;

        for (int i = 0; i < paintingValues.length; i++) {
            findMaxVal(paintingValues, i, new ArrayList<>());
        }

        return maxSeq;
    }

    private void findMaxVal(int[] vals, int pos, ArrayList<Integer> curRes) {
        curRes.add(vals[pos]);

        int nextPos = pos + 2;
        while (nextPos < vals.length) {
            findMaxVal(vals, nextPos, new ArrayList<>(curRes));
            nextPos++;
        }

        if (sum(maxSeq) < sum(curRes)) {
            maxSeq = curRes;
        }
    }

    private int sum(List<Integer> seq) {
        return seq.stream().mapToInt(Integer::intValue).sum();
    }
}
