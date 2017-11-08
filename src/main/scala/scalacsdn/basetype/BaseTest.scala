package scalacsdn.basetype

/**
  * Created by Administrator on 2017/7/12.
  */
object BaseTest extends App{
  //16进制定义法
  val x = 0x29
  println(x)

  //十进制定义法
  val y = 41
  println(y)

//  \n 换行符，其Unicode编码为
//  \b 回退符，其Unicode编码为 (\u0008)
//  \t tab制表符 ，其Unicode编码(\u0009)
//  \” 双引号，其Unicode编码为 (\u0022)
//  \’ 单引号，其Unicode编码为 (\u0027)
//  \ 反斜杆，其Unicode编码为(\u005C)

  //字符串变量用""包裹
  val helloWorld="Hello World"
   println(helloWorld)

  //要定义"Hello World"，可以加入转义符\
  val helloWorldDoubleQuote="\"Hello World\""
  println(helloWorldDoubleQuote)

  //如果希望能够原样输出字符串中的内容，则用三个引号"""将字符串包裹起来，如
  println(""" hello cruel world, \n \\\\ \b \\, I am " experienced" programmer""")
}
