import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

object ImageCrop extends App {
//  val img = ImageIO.read(new File("/home/tomas/MEGA/Obrázky/tales/Screenshot from 2017-01-26 20-46-10.png"))
//  val sub = img.getSubimage(220, 60, 720, 960)
//  val sub = img.getSubimage(985, 60, 720, 965)
//  val out = new File("/home/tomas/MEGA/Obrázky/tales/Screenshot from 2017-01-26 20-46-10test2.png")
//  ImageIO.write

  // file list
  val dir = new File("/home/tomas/MEGA/Obrázky/tales")
  val files = dir.listFiles.filter(_.isFile).toList.sorted

  var count = 2

  for (imgPath <- files) {
    val img = ImageIO.read(imgPath)
    val sub1 = img.getSubimage(222, 60, 720, 965)
    val sub2 = img.getSubimage(985, 60, 720, 965)

    val out1 = new File(s"/home/tomas/MEGA/Obrázky/tales/n/${count-1}.png")
    val out2 = new File(s"/home/tomas/MEGA/Obrázky/tales/n/$count.png")

    ImageIO.write(sub1, "png", out1)
    ImageIO.write(sub2, "png", out2)

    println(s"/home/tomas/MEGA/Obrázky/tales/${count-1}.png")
    println(s"/home/tomas/MEGA/Obrázky/tales/$count.png")
    println()

    count += 2
  }
}
