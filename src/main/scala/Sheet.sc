sealed trait B
case class R (a: Int, b: Int, var c: Int = 3)(val d: Int) extends B
case class G() extends B

val r = R(1, 2)(4)
val a = r.a
val b = r.b
val c = r.c
r.c = 4
val r1 = r.copy(b = 1, c = 3)(5)
val newR: Int => R = R(1, _, 2)(3)
val r2 = newR(40)
r2.b

val g: B = G()

g match {
  case G() => ()
  case R(_, b, _) => ()
}

val l = List(1, 2)

l match {
  case Nil => 1
  case h :: _ => h
}

val l1 = l ++ List(3, 4)

val a1 = Array(1, 2)
val a2 = a1 ++ Array(3, 4) ++ List(5, 6) ++ Seq(7, 8)

val a3 =
  for(b1 <- 1 to 5 if b1 > 3)
    yield (b1, b1)

class MyFunc(name: String, f: Int => Int) extends (Int => Int) {
  override def apply(v1: Int): Int = f(v1)
}

val x = new MyFunc("foo", x => x + 1)
val y = x(23)