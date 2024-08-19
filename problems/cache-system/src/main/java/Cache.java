import eviction.EvictionPolicy;
import exceptions.KeyNotFoundException;
import exceptions.StorageFullException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import storage.Storage;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public void put(final Key key, final Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            log.error("Error adding key, exception:", exception);
            Key keyToEvict = evictionPolicy.keyToRemove();
            if (isNull(keyToEvict)) {
                throw new RuntimeException("Unexpected state, eviction key is null");
            }
            log.info("Evicting key: {}", keyToEvict);
            this.storage.remove(keyToEvict);
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        }
    }

    public Value get(final Key key) {
        try {
            Value returnVal = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return returnVal;
        } catch (KeyNotFoundException exception) {
            log.error("key not found in database");
        }
        return null;

    }
}
