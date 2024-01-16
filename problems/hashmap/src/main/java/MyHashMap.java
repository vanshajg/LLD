public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private final Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];

    }

    public static class Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];

        if (entry == null) {
            buckets[index] = new Entry<>(key, value);
            return;
        }
        Entry<K,V> prevEntry = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            prevEntry = entry;
            entry = entry.next;
        }
        prevEntry.next = new Entry<>(key, value);
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }


}
