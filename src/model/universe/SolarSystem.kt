package model.universe

import model.universe.planet.Planet
import java.util.*

data class SolarSystem(val planets: List<Planet>) {
    companion object {
        fun generateSolarSystems(planets: MutableList<Planet>):
                MutableList<SolarSystem> {
            val planetBins: MutableList<MutableList<Planet>> = ArrayList()
            for (counter in 0..9) {
                planetBins.add(ArrayList())
            }

            var counter = 0
            while (!planets.isEmpty()) {
                planetBins[counter].add(planets.removeAt(0))
                counter = (counter + 1) % planetBins.size
            }

            val output = LinkedList<SolarSystem>()
            for (bin in planetBins) {
                output.add(SolarSystem(bin))
            }

            return output
        }
    }
    val name = planets[0].name
}