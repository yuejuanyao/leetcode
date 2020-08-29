package design;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ifu_cache_460Test {
    volatile Ifu_cache_460 cache ;
    @Before
    public void init(){
        cache = new Ifu_cache_460(2);
    }
    @Test
    public void get() {
        cache.put(1, 1);
        cache.put(1, 1);
        System.out.println(cache.minFreq);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.minFreq);
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4

    }

    @Test
    public void put() {
    }
}