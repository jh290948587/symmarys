package scalacsdn.basetype

/**
  * Created by Administrator on 2017/7/12.
  */
object ArrayTest {
  def main(args: Array[String]): Unit = {
    //定义一个长度为10的数值数组
     var numberArray = new Array[Int](10)
    //定义一个长度为10的String类型数组
     val strArray=new Array[String](10)
    //可以看出：复杂对象类型在数组定义时被初始化为null，数值型被初始化为0

    //数组元素赋值
     strArray(0)="First Element"
    //需要注意的是，val strArray = new Array[String](10)
    //这意味着strArray不能被改变，但数组内容是可以改变的
     println(strArray)
//    res62: Array[String] = Array(First Element, null, null, null, null, null, null,
//      null, null, null)


    //另一种定长数组定义方式
    //这种调用方式其实是调用其apply方法进行数组创建操作
     val strArray2=Array("First","Second")
//    strArray2: Array[String] = Array(First, Second)

//    Scala中的Array以Java中的Array方式实现
  }
}
