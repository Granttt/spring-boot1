package com.example.gxy.demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GXY
 * @Package com.example.gxy.demo
 * @date 2020/12/6 18:07
 * @Copyright © 2020-2021 新流通
 * @Description:布隆过滤器的方式解决缓存穿透问题
 * https://www.cnblogs.com/rinack/p/9712477.html
 */
public class BloomFilterTest {

    private static int size = 1000000;

    private static BloomFilter<Integer> bloomFilter =BloomFilter.create(Funnels.integerFunnel(), size);

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        List<Integer> list = new ArrayList<Integer>(1000);
        //故意取10000个不在过滤器里的值，看看有多少个会被认为在过滤器里
        for (int i = size + 10000; i < size + 20000; i++) {
            //mightContain()方法负责判断元素是否存在
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }
        System.out.println("误判的数量：" + list.size());
    }
}
