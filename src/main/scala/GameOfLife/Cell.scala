package GameOfLife

/**
  * Created by Tomáš Derner on 21.1.17.
  */
class Cell(val grid: Grid, val row: Int, val col: Int, var alive: Boolean) {
  def apply(): Boolean = alive
  def update(alive: Boolean): Unit = this.alive = alive

  def aliveNextStep(): Boolean = {
    val neighbors = (grid(row-1, col-1) ::
      grid(row-1, col) ::
      grid(row-1, col+1) ::
      grid(row, col-1) ::
      grid(row, col+1) ::
      grid(row+1, col-1) ::
      grid(row+1, col) ::
      grid(row+1, col+1) ::
      Nil).foldLeft(0) {(i: Int, cell: Cell) => if (cell()) i+1 else i}
    Rules.isAlive(alive, neighbors)
  }
}
