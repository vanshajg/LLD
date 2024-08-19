package storage;

import exceptions.KeyNotFoundException;
import exceptions.StorageFullException;

public interface Storage<Key, Value> {

    void add(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws KeyNotFoundException;

    void remove(Key key);

}
