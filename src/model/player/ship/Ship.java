package model.player.ship;

import java.io.Serializable;

/**
 * Class that represents ships
 */
public class Ship implements Serializable {
    private static final int STARTING_FUEL_AMOUNT = 10000;

    private ShipType type;

    /**
     * Constructor for Ship class
     *
     * @param type - the type of the ship
     */
    public Ship(ShipType type) {
        this.type  = type;
    }

    /**
     * Gets the ship type
     * @return the ship type
     */
    public ShipType getType() {
        return type;
    }

    /**
     * sets the ship type
     * @param type - the type of the ship
     */
    public void setType(ShipType type) {
        this.type = type;
    }

}
