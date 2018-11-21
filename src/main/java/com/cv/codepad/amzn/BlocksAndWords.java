package com.cv.codepad.amzn;

import java.util.*;

/*
Given a list of blocks each of which has upto n faces and a letter on each face, return true if a given word can be
formed from the blocks

(A,B), (B,A), (A,B), (X,Y) ; BABY -> true
but
(A,B), (B,A), (L,E), (B,A) ; ABLE -> false
 */
public class BlocksAndWords {

    public static void main(String[] args) {
        BlocksAndWords sol = new BlocksAndWords();

        /*sol.solve(Arrays.asList(
                Arrays.asList('A', 'B'),
                Arrays.asList('B', 'A'),
                Arrays.asList('B', 'A'),
                Arrays.asList('X', 'Y')), "BABY"); */
        sol.solve(Arrays.asList(
                Arrays.asList('A', 'B'),
                Arrays.asList('B', 'A'),
                Arrays.asList('L', 'E'),
                Arrays.asList('A', 'Y')), "ABLE");
    }

    public boolean canMakeWord(List<Block> blocks, String word) {
        return canMakeWord(blocks, word, 0);
    }

    private boolean canMakeWord(List<Block> blocks, String word, int index) {
        if (blocks.size() != word.length() - index) {
            return false;
        }
        if (index >= word.length()) {
            return true;
        }
        ListIterator<Block> it = blocks.listIterator();
        while (it.hasNext()) {
            Block thisBlock = it.next();
            if (thisBlock.hasFace(word.charAt(index))) {
                it.remove();
                if (!canMakeWord(blocks, word, index + 1)) {
                    it.add(thisBlock);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void solve(List<List<Character>> blocks, String word) {
        List<Block> blockSet = new ArrayList<>();
        for (List<Character> block : blocks) {
            blockSet.add(new Block(block));
        }
        System.out.println(canMakeWord(blockSet, word));
    }

    class Block {
        Set<Character> faces;

        public Block(List<Character> faces) {
            this.faces = new HashSet<>();
            this.faces.addAll(faces);
        }

        public boolean hasFace(Character c) {
            return faces.contains(c);
        }
    }

}
