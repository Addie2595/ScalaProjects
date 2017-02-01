package GameOfLife

object Rules {
  def isAlive(alive: Boolean, neighbors: Int): Boolean = {
    neighbors match {
      case 0 => false
      case 1 => false
      case 2 => if (alive) true else false
      case 3 => true
      case 4 => if (alive) true else false
      case 5 => false
      case 6 => false
      case 7 => false
      case 8 => false
    }
  }
}
