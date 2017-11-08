package classandobject.itcast

/**
  * Created by Administrator on 2017/7/20.
  */
class ApplyTest(val name: String,val age: Int) {

}

object ApplyTest {
  def main(args: Array[String]): Unit = {
    Array(2,3)
    val a = ApplyTest("lixiang",12)
  }
  def apply(name: String,age: Int): ApplyTest = new ApplyTest(name,age)
}
