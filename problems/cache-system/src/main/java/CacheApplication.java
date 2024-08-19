import eviction.LRUEvictionPolicy;
import storage.HashBasedStorage;

public class CacheApplication {
    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(
                new LRUEvictionPolicy<>(),
                new HashBasedStorage<>(10)
        );

        cache.put("hello", 1);
        cache.put("world", 2);
        cache.put("foo", 3);
        cache.put("bar", 4);
        cache.put("hello", 5);
        cache.put("baz", 5);
        cache.put("qux", 6);
        cache.put("quux", 7);
        cache.put("corge", 8);
        cache.put("grault", 9);
        cache.put("garply", 10);
        cache.put("waldo", 11);
        cache.put("fred", 12);

    }
}
