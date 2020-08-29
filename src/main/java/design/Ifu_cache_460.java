package design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Ifu_cache_460 {
    Map<Integer, Node> cacheMap;
    Map<Integer, LinkedHashSet<Node>> freqLinked;
    Integer capacity;
    Integer size = 0;
    Integer minFreq = 0;

    public Ifu_cache_460(int capacity) {
        cacheMap = new HashMap<>();
        freqLinked = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node cur = cacheMap.get(key);
        if (cur == null) {
            return -1;
        } else {
            //增加该节点的频率；
            addFreq(cur);
            //返回该节点的值
            return cur.value;
        }
    }

    private void addFreq(Node cur) {
        //从所在的key= cur.freq 的list移除
        int nodeFreq = cur.freq;
        LinkedHashSet<Node> set = freqLinked.get(nodeFreq);
        set.remove(cur);
        if (set.size() == 0 && nodeFreq == minFreq)
            minFreq = nodeFreq + 1;
        cur.freq += 1;
        //增加到 key= cur.freq +1 的list
        LinkedHashSet<Node> setNew = freqLinked.get(cur.freq);
        if (setNew == null) {
            setNew = new LinkedHashSet<>();
            freqLinked.put(cur.freq, setNew);
        }
        setNew.add(cur);

    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        //检查是否有该节点
        Node cur = cacheMap.get(key);
        if (cur == null) {
            if (size.equals(capacity))
                removeLessUsed();
            cur = new Node(key, value);
            cacheMap.put(key, cur);
            if (freqLinked.containsKey(cur.freq)) {
                freqLinked.get(cur.freq).add(cur);
            } else {
                LinkedHashSet<Node> setNew = new LinkedHashSet<>();
                setNew.add(cur);
                freqLinked.put(cur.freq, setNew);
            }
            minFreq = 1;
            size++;

        } else {
            //增加该节点的频率；
            cur.value = value;
            addFreq(cur);
        }
    }

    private void removeLessUsed() {
        if (size <= 0)
            return;
        LinkedHashSet<Node> set = freqLinked.get(minFreq);
        Node deleteNode = set.iterator().next();
        set.remove(deleteNode);
        cacheMap.remove(deleteNode.key);
        size--;
    }

    class Node {
        int key;
        int value;
        int freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
}
