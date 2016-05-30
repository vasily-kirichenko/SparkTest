import scala.collection._
import scala.util.Random

object Utils {
  def timeMillis[A](f: => A): (A, Long) = {
    val s = System.nanoTime
    val ret = f
    (ret, ((System.nanoTime - s) / 1e6).toLong)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val source = Seq.fill(50000000){Random.nextInt()}.toArray
    val m = mutable.HashMap.empty[Int, Int]

    val (_, elapsed) = Utils.timeMillis {
      for (x <- source) {
        m += (x -> 0)
      }
    }

    println(s"Insertion: $elapsed ms")
  }
}
