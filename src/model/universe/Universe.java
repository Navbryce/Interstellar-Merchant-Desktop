package model.universe;

import java.util.List;

public class Universe {
    List<SolarSystem> solarSystems;

    public Universe(List<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (SolarSystem system: solarSystems) {
            builder.append(system.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
