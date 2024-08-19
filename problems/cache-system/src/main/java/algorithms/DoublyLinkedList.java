package algorithms;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DoublyLinkedList<E> {

    private final DoublyLinkedListElement<E> bufferHead = new DoublyLinkedListElement<>(null);
    private final DoublyLinkedListElement<E> bufferTail = new DoublyLinkedListElement<>(null);

    public DoublyLinkedList() {
        bufferHead.setNext(bufferTail);
        bufferTail.setPrevious(bufferHead);
    }

    public void detach(@NotNull DoublyLinkedListElement<E> node) {
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }

    @Nullable
    public DoublyLinkedListElement<E> getFirstNode() {
        if (isEmpty()) {
            return null;
        }
        return bufferHead.getNext();
    }

    public void addAtLast(@NotNull DoublyLinkedListElement<E> node) {
        bufferTail.getPrevious().setNext(node);
        node.setPrevious(bufferTail.getPrevious());
        node.setNext(bufferTail);
        bufferTail.setPrevious(node);
    }

    public boolean isEmpty() {
        return bufferHead.getNext().equals(bufferTail);
    }

}
