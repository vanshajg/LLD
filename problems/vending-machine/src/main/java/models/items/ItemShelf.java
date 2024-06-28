package models.items;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class ItemShelf {

    private final Map<String, Item> items = new HashMap<>();

}
