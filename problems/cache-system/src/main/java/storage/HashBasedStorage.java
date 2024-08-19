package storage;

import exceptions.KeyNotFoundException;
import exceptions.StorageFullException;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class HashBasedStorage<Key, Value> implements Storage<Key, Value> {

    private final Map<Key, Value> storage = new HashMap<>();
    private final int capacity;

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (storage.containsKey(key)) {
            storage.put(key, value);
            return;
        }
        if (isFull()) {
            throw new StorageFullException();
        }
        storage.put(key, value);

    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        if (!storage.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        return storage.get(key);
    }

    @Override
    public void remove(Key key) {
        if (!storage.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        storage.remove(key);
    }

    private boolean isFull() {
        return capacity <= storage.size();
    }

}
