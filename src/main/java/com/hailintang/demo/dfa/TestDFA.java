package com.hailintang.demo.dfa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hailin.tang
 * @date 2020/4/20 3:41 下午
 * @function
 */
public class TestDFA {
    //加载敏感词到map中
    public void loadWord(Set<String> sensitiveWordSet) {
        HashMap sensitiveWordMap = new HashMap(sensitiveWordSet.size());

        String key = null;

        Map nowMap = null;

        Map<String, String> newWordMap = null;

        Iterator<String> iterator = sensitiveWordSet.iterator();

        while (iterator.hasNext()) {
            key = iterator.next();
            nowMap = sensitiveWordMap;

            if (key == null || key.equals("")) {
                return;
            }

            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);

                Object wordMap = nowMap.get(keyChar);

                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd","0");
                    nowMap.put(keyChar,newWordMap);
                    nowMap = newWordMap;
                }
                if(i == key.length()-1){
                    newWordMap.put("isEnd","1");
                }
            }
        }
    }
}
