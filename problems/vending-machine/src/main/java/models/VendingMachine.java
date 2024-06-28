package models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import models.items.ItemShelf;
import models.state.IdleState;
import models.state.State;

@Getter
@Setter
public class VendingMachine {
    private final List<Integer> coins = new ArrayList<>();
    private State state = new IdleState();
    private final ItemShelf itemShelf = new ItemShelf();

}
