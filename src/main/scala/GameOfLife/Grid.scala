package GameOfLife

class Grid(val rows: Int, val cols: Int) extends Traversable[Cell] {
  private val grid = Array.ofDim[Cell](rows, cols)

  def apply(row: Int, col: Int): Cell = {
    val realRow = if (row >= 0) row % rows else rows + (row % rows)
    val realCol = if (col >= 0) col % cols else cols + (col % cols)
    grid(realRow)(realCol)
  }

  def update(row: Int, col: Int, cell: Cell): Unit = grid(row)(col) = cell

  def initialize(): Grid = {
    for (row <- 0 until rows)
      for (col <- 0 until cols)
        grid(row)(col) = new Cell(this, row, col, false)
    this
  }

  override def foreach[U](f: (Cell) => U): Unit = grid.foreach(row => row.foreach(f))

}
