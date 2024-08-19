package eviction;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key k);

    Key keyToRemove();

}
