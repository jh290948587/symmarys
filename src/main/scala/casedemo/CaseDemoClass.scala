package casedemo

import scala.util.Random
case class SubmitTask(id: String, name: String)
case class HeartBeat(time: Long)
case object CheckTimeOutTask
/**
  * Created by Administrator on 2017/7/11.
  */
object CaseDemoClass extends App{
  val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))

  val a = arr(Random.nextInt(arr.length)) match {
    case SubmitTask(id, name) => {
      7
    }
    case HeartBeat(time) => {
      6
    }
    case CheckTimeOutTask =>
      9
  }
  println(a)
}
