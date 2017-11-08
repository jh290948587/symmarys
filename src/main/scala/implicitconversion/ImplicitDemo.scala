package implicitconversion

/**
  * Created by Administrator on 2017/7/11.
  */
class Men{}

class SuperMen(men: Men){
  def kucha(): Unit ={
    println("超人裤衩反穿")
  }
}



object ImplicitDemo extends App{
//  隐式转换
  implicit def menToSuperMen(men: Men) = new SuperMen(men)
  val men = new Men
  men.kucha()

//  隐式参数
  implicit val name = "我是隐式参数"
  implicit val age = 11
  def param(implicit haha: String,heihei: Int)={
    println(haha+heihei)
  }
  param

//  隐式类
  implicit class Cals(x: Int){
    def add(a: Int) = {
      a + 12
    }
  }
  val num = 1.add(2)
  println(num)
}

