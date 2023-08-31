package com.example.algorithms.GreedyAlgorithm

class Greedy {
}

data class Lessons(val beginOfLesson: Int, val finishOfLesson: Int, val subject: String)


val toDoList = listOf(
    Lessons(8, 9, "Kotlin"), Lessons(9, 10, "C++"),
    Lessons(10, 12, "Computer Science"), Lessons(11, 13, "Java"),
    Lessons(12, 13, "PE"), Lessons(13, 16, "Python"),
    Lessons(15, 19, "Scala"), Lessons(14, 22, "PingPong")
)
fun myGreedy(list:List<Lessons>,
//             timeYouHave:Int
){
    val totalLessons = mutableListOf<Lessons>()
    list.sortedBy { it.finishOfLesson }


    for (i in list.indices){
        if (totalLessons.isEmpty()){
            totalLessons.add(list[i])
        }else{
            if (list[i].beginOfLesson>=list[i-1].finishOfLesson){
                totalLessons.add(list[i])

            }


        }}

    println(totalLessons)

}
fun main() {
    myGreedy(toDoList)
}