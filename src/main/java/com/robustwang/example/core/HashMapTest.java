package com.robustwang.example.core;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "true");
        map.put(null, null);
        map.put("2",null);

        map.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
    }
}
