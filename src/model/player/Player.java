package model.player;

import model.player.game_config.Difficulty;
import model.player.game_config.GameConfig;
import model.player.ship.Ship;
import model.player.ship.ShipType;

import java.io.Serializable;

/**
 * Represents a Player in the game. A singleton
 */

public class Player implements Serializable {
    private static final int MAXIMUM_POINTS = 16;
    public static final int STARTING_CREDITS = 1000;

    // skill points mapping for the skill area
    public static final int PILOT = 0;
    public static final int FIGHTER = 1;
    public static final int TRADER = 2;
    public static final int ENGINEER = 3;

    private final GameConfig config;
    private Ship ship;
    private int credits;
    @SuppressWarnings("FieldMayBeFinal")
    private final String name;
    private final int[] skillPoints; // each index represents a skill

    /**
     * the constructor for the Player
     *
     * @param skills - the skills of the player (max size of 4)
     * @param ship - the player's ship
     * @param name - the name of the player
     * @param config - the game config
     */
    public Player(int[] skills, Ship ship, String name, GameConfig config) {
        // handle skill points
        if (skills.length != 4) {
            throw new IllegalArgumentException("The skills array is invalid");
        }
        this.skillPoints = skills.clone();
        if (!appropriateNumberOfSkillPoints()) {
            throw new IllegalArgumentException("You must have " +
            Player.MAXIMUM_POINTS + " points");
        }

        // handle other parameters
        this.ship = ship;
        this.credits = Player.STARTING_CREDITS;
        if ((name == null) || name.isEmpty()) {
            throw new IllegalArgumentException("You must give the player a name");
        } else {
            this.name = name;
        }

        if (config == null) {
            throw new IllegalArgumentException("Game config can't be null");
        } else {
            this.config = config;
        }

    }

    /**
     * the constructor for the player. gives the player a default ship
     * @param skillBean - holds skill info
     * @param name - the name skill
     * @param config - the game config
     */
    public Player(SkillBean skillBean, String name,
                  GameConfig config) {
        this(new int[] {skillBean.getPilot(), skillBean.getFighter(), skillBean.getTrader(),
                skillBean.getEngineer()}, new Ship(ShipType.GNAT), name, config);
    }

    /**
     * the constructor for the player. gives players defaults for all values
     * @param config - the game config
     */
    public Player(GameConfig config) {
        this(
                new SkillBean(0, 0, 0, 0), "Default name",
                config);
    }

    /**
     * the constructor for the player. gives players defaults for all values
     */
    public Player() {
        this(
                new SkillBean(0, 0, 0, 0), "Default name",
                new GameConfig(Difficulty.Hard));
    }

    /**
     * Returns true if the player does not have more than the max number of skill points
     *
     * @return if the player does not have more than the max skill points
     */
    private boolean appropriateNumberOfSkillPoints() {
        return getTotalSkillPoints() == Player.MAXIMUM_POINTS;
    }

    /**
     * Finds all the points not invested by the playter
     * @return the skills points that have not ben invested by the player
     */
    public int getAvailableSkillPoints() {
        return Player.MAXIMUM_POINTS - getTotalSkillPoints();
    }

    /**
     * Sums all of the skill points invested by a player
     * @return all the skill points invested by a player
     */
    private int getTotalSkillPoints() {
        int sum = 0;
        for (int skill: skillPoints) {
            sum += skill;
        }
        return sum;
    }

    /**
     * gets the game config
     * @return gets the game config
     */
    public GameConfig getConfig() {
        return config;
    }

    /**
     * gets the game difficulty
     * @return the game difficulty
     */
    public Difficulty getDifficulty() {
        return config.getGameDifficulty();
    }

    /**
     * Sets the credits
     * @param newValue - the new value of the credits
     */
    public void setCredits(int newValue) {
        this.credits = newValue;
    }

    /**
     * gets the player's credits
     * @return the player's credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * gets the player's name
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    public Ship getShip() {
        return ship;
    }

    /**
     * get's the player's ship type
     * @return the player's ship type
     */
    public ShipType getShipType() {
        return ship.getType();
    }

    /**
     * gets the player's skill points
     * @return the player's skill points
     */
    public int[] getSkillPoints() {
        return skillPoints.clone();
    }

    public static class SkillBean {
        private final int pilot;
        private final int fighter;
        private final int trader;
        private final int engineer;

        /**
         * @param pilot - the pilot skill
         * @param fighter - the fighter skill
         * @param trader - the trader skill
         * @param engineer - the engineer skill
         */
        public SkillBean(int pilot, int fighter, int trader, int engineer) {
            this.pilot = pilot;
            this.fighter = fighter;
            this.trader = trader;
            this.engineer = engineer;
        }

        /**
         * Gets pilot skill
         * @return - the pilot skill
         */
        int getPilot() {
            return pilot;
        }

        /**
         * Gets the figher skill
         * @return - the fighter skill
         */
        int getFighter() {
            return fighter;
        }

        /**
         * Gets the trader skill
         * @return - the trader skill
         */
        int getTrader() {
            return trader;
        }

        /**
         * Gets the engineer skill
         * @return - the engineer skill
         */
        int getEngineer() {
            return engineer;
        }
    }
}
