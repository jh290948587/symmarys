package casedemo

/**
  * Created by Administrator on 2017/7/11.
  */
object CaseDemoArrayAndRange extends App{
//  val arr = Array(1, 3, 5)
//  val arr = Array(1, 3, 5)
  val arr = Array(0, 3)
  arr match {
    case Array(3, x, y) => println(x + " " + y)
    case Array(3, _*) => println("only 0")
    case Array(3, _) => println("0 ...")
    case _ => println("something else")
  }

  val lst = List(3, -1)
  lst match {
    case 0 :: Nil => println("only 0")
    case x :: y :: Nil => println(s"x: $x y: $y")
    case 0 :: tail => println("0 ...")
    case _ => println("something else")
  }

  val tup = (2, 3, 7)
  tup match {
    case (1, x, y) => println(s"1, $x , $y")
    case (_, z, 5) => println(z)
    case _ => println("else")
  }

}
