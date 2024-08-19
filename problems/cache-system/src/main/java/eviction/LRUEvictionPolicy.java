package eviction;

import algorithms.DoublyLinkedList;
import algorithms.DoublyLinkedListElement;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final DoublyLinkedList<Key> linkedList = new DoublyLinkedList<>();
    private final Map<Key, DoublyLinkedListElement<Key>> hash = new HashMap<>();

    @Override
    public void keyAccessed(Key key) {
        if (hash.containsKey(key)) {
            linkedList.detach(hash.get(key));
            linkedList.addAtLast(hash.get(key));
        } else {
            DoublyLinkedListElement<Key> newNode = new DoublyLinkedListElement<>(key);
            hash.put(key, newNode);
            linkedList.addAtLast(newNode);
        }
    }

    @Nullable
    @Override
    public Key keyToRemove() {
        DoublyLinkedListElement<Key> evictCandidate = linkedList.getFirstNode();
        if (isNull(evictCandidate)) {
            return null;
        }
        linkedList.detach(evictCandidate);
        hash.remove(evictCandidate.getValue());
        return evictCandidate.getValue();
    }
}
