package model.universe.planet;

/**
 * Resource enum to keep track of resources
 */
public enum Resource {
    NOSPECIALRESOURCES, MINERALRICH, MINERALPOOR, DESERT, LOTSOFWATER, RICHSOIL, POORSOIL,
    RICHFAUNA, LIFELESS, WEIRDMUSHROOMS, LOTSOFHERBS, ARTISTIC, WARLIKE;


    /**
     * Gets a random resource
     * @return the random resource
     */
    public static Resource getRandomResource() {
        Resource[] resources = Resource.values();
        return resources[(int) (Math.random() * resources.length)];
    }
}
