package homework

import u04lab.code.{Course, Student}
import u04lab.code.Lists.List
import u04lab.code.Lists.List._
import u04lab.code.Lists.List.{Cons, Nil}

case class StudentImpl(name: String, year:Int) extends Student {
  private var coursesList: List[Course] = Nil()

  override def courses:List[String] = map(coursesList)(c => c.name)
  override def hasTeacher(teacher: String): Boolean = contains(map(coursesList)(c => c.teacher), teacher)
  override def enrolling(course: Course*): Unit =
    course.foreach(c => coursesList = append(Cons(c, Nil()), coursesList))


}
