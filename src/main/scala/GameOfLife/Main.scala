package SFXCanvasTest

import GameOfLife.{Cell, Grid}

import scala.util.Random
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color

object Main extends JFXApp {
  private val squareSide = 10
  private val rows = 100
  private val columns = 180
  private var grid = new Grid(rows, columns).initialize()

  val canvas = new Canvas(squareSide * columns, squareSide * rows)
  val draw = canvas.graphicsContext2D

  var stepFinished = true
  var running = false

  stage = new PrimaryStage {
    title = "Canvas Drawing"
    resizable = false
    scene = new Scene(canvas.width.value, canvas.height.value) {
      val rootPane = new BorderPane()
      rootPane.center = canvas
      root = rootPane

      handleEvent(KeyEvent.KeyPressed) {e: KeyEvent =>
        if (e.code == KeyCode.Space)
          if (running) {
            timer.stop()
            running = false
          } else {
            timer.start()
            running = true
          }
        else if (e.code == KeyCode.Enter) if (stepFinished) step()
      }
    }
  }

  def redrawSquare(row: Int, col: Int): Unit = {
    if (grid(row, col).alive) draw.fill = Color.color(0.2, 0.2, 0.2)
    else draw.fill = Color.color(0.7, 0.7, 0.7)
    val x = squareSide * col
    val y = squareSide * row
    draw.lineWidth = 1
    draw.stroke = Color.color(0.85,0.85,0.85)
    draw.fillRect(x, y, squareSide, squareSide)
    draw.strokeRect(x, y, squareSide, squareSide)
  }

  def drawGrid(): Unit = {
    grid.foreach(cell => redrawSquare(cell.row, cell.col))
  }

  def step(): Unit = {
    stepFinished = false
    println("Step")
    val nextGrid = new Grid(rows, columns)
    grid.foreach(cell => nextGrid(cell.row, cell.col) = new Cell(grid, cell.row, cell.col, cell.aliveNextStep()))
    grid = nextGrid
    drawGrid()
    stepFinished = true
  }

  val timer = AnimationTimer(t => if (stepFinished) step())

//  grid(3+45,3+70).alive = true
//  grid(5+45,3+70).alive = true
//  grid(5+45,2+70).alive = true
//  grid(4+45,5+70).alive = true
//  grid(5+45,6+70).alive = true
//  grid(5+45,7+70).alive = true
//  grid(5+45,8+70).alive = true

  grid(50,65).alive = true
  grid(50,66).alive = true
  grid(50,67).alive = true
  grid(50,68).alive = true
  grid(50,69).alive = true
  grid(50,70).alive = true
  grid(50,71).alive = true
  grid(50,72).alive = true
  grid(50,73).alive = true
  grid(50,74).alive = true
  grid(50,75).alive = true

  drawGrid()
}
