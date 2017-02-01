import org.jsoup.Jsoup

object JSoupTest extends App {
  val site = Jsoup.connect("http://google.cz/").get()
  println(site)
}
