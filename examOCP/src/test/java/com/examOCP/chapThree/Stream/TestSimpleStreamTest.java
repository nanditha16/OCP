package com.examOCP.chapThree.Stream;

import com.examOCP.misc.Patterns.RegularExpressionConcepts;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestSimpleStreamTest {

    private TestSimpleStream m;

    @org.junit.Before
    public void setUp() throws Exception {
        m = new TestSimpleStream();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void processListOfMaps() {
        Map<String, String> bookAlgos = new HashMap<>();
        bookAlgos.put("555", "abc");
        bookAlgos.put("666", "Algo");
        bookAlgos.put("777", "valid");

        Map<String, String> bookFics = new HashMap<>();
        bookFics.put("555", "abc");
        bookFics.put("666", "Fic");
        bookFics.put("777", "valid");

        List<Map> l = new ArrayList<>(Arrays.asList(bookAlgos, bookFics));

        List<Map> transformed = new ArrayList<Map>() ;

        l.stream().map(map -> {
            Set<String> keys = map.keySet() ;
            Map<String, String> newMap = new HashMap<>();
            for(String key : keys){
                if(key.equals("666")) {
                    newMap.put(key, map.get(key).toString());
                }
            }
            return newMap ;
        }).filter(e -> e.containsValue("Algo"))
                .forEach(System.out::println);
               // .forEach(map -> transformed.add(map));

       // assertEquals(true, keySet.isPresent());


    }

    @Test
    public void processMapUsingFilter() {
        Map<String, String> books = new HashMap<>();
        books.put("555", "abc");
        books.put("666", "Algo");
        books.put("777", "valid");

        // get the value of the specified key (using filter)
        Optional<String> keySet = books.entrySet().stream()
                .filter(e -> e.getKey().equals("666"))
                .map(Map.Entry::getValue)
                .findFirst();
        System.out.println(keySet.get());

        // to has to have a value
        assertEquals(true, keySet.isPresent());


    }
}