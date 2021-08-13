package com.coder.yingen.algorithm;

import android.app.job.JobInfo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.Inflater;

import kotlin.TuplesKt;

/**
 * Created by Alex Chu on 2021/8/11.
 */
public class SelfDefinedLRU<K,V> extends LinkedHashMap<K,V> implements Map<K,V> {
    private static final long serialVersionUID = 1l;

    public SelfDefinedLRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor,accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        if (size() > 6) {
            return true;
        }
        return false;
    }
}
