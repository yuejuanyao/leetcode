package practice1;

import java.util.HashMap;
import java.util.Map;

public class Short_encoding_of_words_820_1 {
    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        if (words == null || words.length <= 0)
            return count;
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> map = new HashMap<>();
        for (int i = 0; i< words.length; i++){
            String word = words[i];
            TrieNode cur = root;
            for (int j=word.length()-1; j>=0; j--){
                cur = cur.insert(word.charAt(j));
            }
            map.put(cur, i);
        }
        // 有一种可能是me 插入进去了，然后time也插入进去了，区别是，m节点的孩子数量不为0
        for (TrieNode t : map.keySet()){
            if (t.count == 0)
                count += words[map.get(t)].length() + 1;
        }
        return count;
    }

}
class TrieNode{
    int count;
    TrieNode[] children;
    public TrieNode(){
        this.count = 0;
        children = new TrieNode[26];
    }

    public TrieNode insert(char insertC){
        int index = insertC-'a';
        if (children[index] == null){
            children[index] = new TrieNode();
            count++;
        }
        return children[index];
    }
}
