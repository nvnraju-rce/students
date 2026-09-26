package com.rce.collections;

import java.util.HashMap;

public class CharacterFrequency {
    public static void main(String[] args) {

        String str = "banana";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Character frequency: " + map);
    }
}
