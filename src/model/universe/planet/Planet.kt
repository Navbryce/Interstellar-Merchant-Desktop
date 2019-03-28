package model.universe.planet

import java.util.*
import kotlin.math.roundToInt

data class Planet(val name: String, val tech: Tech = Tech.getRandomTech(),
                  val resource: Resource = Resource.getRandomResource(),
                  val x: Int = getRandomCoordinate(), val
                  y: Int = getRandomCoordinate()) {
    companion object {
        const val MAX_COORDINATE = 500

        fun getRandomCoordinate(): Int {
            return (Math.random() * MAX_COORDINATE).roundToInt();
        }

        fun getPlanets(): List<Planet> {
            val list: MutableList<Planet> = LinkedList()
            list.add(Planet("Aregorn", x=500, y=200))
            list.add(Planet("Dunkirk", x=100, y=242))
            list.add(Planet("Aet", x=300, y=221))
            list.add(Planet("Gorbachev", x=422, y=5))
            list.add(Planet("Taii", x=111, y=113))
            list.add(Planet("Maui", x=123, y=233))
            list.add(Planet("Satoria", x=5, y=6))
            list.add(Planet("Zephry", x=50, y=277))
            list.add(Planet("Van", x=355, y=22))
            list.add(Planet("Helle", x=135, y=192))


            return list
        }
    }
}
