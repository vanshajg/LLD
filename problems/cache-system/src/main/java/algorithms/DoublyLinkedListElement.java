package algorithms;

import lombok.Data;

@Data
public class DoublyLinkedListElement<E> {

    private DoublyLinkedListElement<E> previous = null;
    private DoublyLinkedListElement<E> next = null;
    private final E value;

}
