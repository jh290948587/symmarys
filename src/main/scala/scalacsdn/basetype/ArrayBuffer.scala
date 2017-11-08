package scalacsdn.basetype

/**
  * Created by Administrator on 2017/7/12.
  */
class ArrayBuffer {

}

object ArrayBuffer{
  def main(args: Array[String]): Unit = {
    //要使用ArrayBuffer，先要引入scala.collection.mutable.ArrayBuffer
    import scala.collection.mutable.ArrayBuffer

    //创建String类型ArrayBuffer数组缓冲
//     val strArrayVar =ArrayBuffer[String]()
//    strArrayVar: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer()

    //+=意思是在尾部添加元素
//         strArrayVar+="Hello"
//    res63: strArrayVar.type = ArrayBuffer(Hello)

    //+=后面还可以跟多个元素的集合
    //注意操作后的返回值
//     strArrayVar+=("World","Programmer")
//    res64: strArrayVar.type = ArrayBuffer(Hello, World, Programmer)

    //显示完整数组内容
//     strArrayVar
//    res65: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Hello, World,
//      Programmer)

    //++=用于向数组中追加内容，++=右侧可以是任何集合
    //追加Array数组
//     strArrayVar++=Array("Wllcome","To","XueTuWuYou")
//    res66: strArrayVar.type = ArrayBuffer(Hello, World, Programmer, Wllcome, To, Xue
//      TuWuYou)
    //追加List
//     strArrayVar++=List("Wellcome","To","XueTuWuYou")
//    res67: strArrayVar.type = ArrayBuffer(Hello, World, Programmer, Wllcome, To, Xue
//      TuWuYou, Wellcome, To, XueTuWuYou)

    //删除末尾n个元素
//     strArrayVar.trimEnd(3)

//     strArrayVar
//    res69: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Hello, World,
//      Programmer, Wllcome, To, XueTuWuYou)
  }
}
