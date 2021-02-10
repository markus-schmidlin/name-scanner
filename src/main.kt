import java.lang.Thread.sleep
import java.net.URL
import java.nio.file.Paths

fun main() {
  var counter = 0

  Paths.get("C:\\Optravis\\scanner\\src\\names.txt").toFile()
      .readLines()
      .forEach { name ->
        ++counter

        val html = URL("https://namemc.com/search?q=$name").readText()
        if (!html.contains("Unavailable")) {
          println("found $name")
        }

        sleep(11000)

        if(++counter % 10 == 0) println("checking $name..")
      }
}