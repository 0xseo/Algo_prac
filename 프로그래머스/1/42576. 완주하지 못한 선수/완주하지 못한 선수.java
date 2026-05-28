import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String name: participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name)+1);
            } else {
                map.put(name, 1);
            }
        }
        
        for (String name: completion) {
            if (map.get(name) == 1) {
                map.remove(name);
            } else {
                map.put(name, map.get(name)-1);
            }
        }
        String answer = "";
        for (String key: map.keySet()) {
            answer = key;
        }
        return answer;
    }
}