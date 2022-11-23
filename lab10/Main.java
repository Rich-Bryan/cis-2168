import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> result1 = new HashMap<>();
        HashMap<String, Integer> result2 = new HashMap<>();

        result1.put("aiko",2);
        result1.put("fluffy",5);
        result1.put("zugzwang",10);

        result2.put("fluffy",1);
        result2.put("aiko",5);
        result2.put("panda",2222);

        //"aiko": 2, "fluffy": 5, "zugzwang": 10]
        //and
        //["fluffy": 1, "aiko": 5, "panda": 2222]

        //output ["fluffy": 6, "zugzwang": 10, "aiko:" 7, "panda": 2222]

        //System.out.println(checkMap(result1,result2));
        HashMap<String,String> map = new HashMap<>();
        map.put("monday", "1");
        map.put("monday","10");
        map.put("tuesday", "2");


        System.out.println(map);

    }

    public static HashMap<String,Integer> checkMap(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
        HashMap<String, Integer> result = new HashMap<>();

        result.putAll(map2);

        for(String key1 : map1.keySet()){
            if(result.containsKey(key1)){
                result.put(key1, map1.get(key1) + map2.get(key1));

            }else{
                result.put(key1, map1.get(key1));
            }


        }

        return result;
    }
}

