fun main() {
    println("please make your choice ")
    println("1. Add student")
    println("2. Add Instructor")
    println("3. Create Course")
    println("4. enroll Student in course")
    println("5.List Students")
    println("6.List Instructors")
    println("7.list Courses")
    println("8.Exit")
    val classroom = Classroom(mutableListOf(), mutableListOf(), mutableListOf())
    do {


        val userChoice = readln().toInt()
            //        ------------------------------------------
        if (userChoice == 1) {
            println("please enter Student Id")
            val studentId = readln().toString()
            println("Please enter student name ")
            val studentName = readln().toString()
            val student = Student(studentId, studentName, mutableListOf())
            classroom.addStudent(student)
            //        ------------------------------------------

        } else if (userChoice == 2) {
            println("please enter Instructor Id")
            val instructorId = readln().toString()
            println("Please enter instructor name ")
            val instructorName = readln().toString()
            val instructor = Instructor(instructorId, instructorName, mutableListOf())
            classroom.addInstructor(instructor)
            //        ------------------------------------------

        } else if (userChoice == 3) {
            println(" please enter course name :")
            val courseName = readln().toString()
            if (classroom.checkCourseName(courseName)== null){
            println(" please enter instructor name : ")
            val instructorName = readln().toString()
            if (classroom.searchForInstructor(instructorName)!= null){
                val course = Course(courseName, classroom.searchForInstructor(instructorName), mutableListOf())
                classroom.createNewCourse(course, classroom.searchForInstructor(instructorName)!!)
            }else{
                println("the instructor isn't in the database , please check the name or  enter 2 to add the instructor ")
            }
                }else {
                    println(" the course is already added ")
            }
            //        ------------------------------------------

        } else if (userChoice == 4) {
            println("please enter the name of added student ")
            val student = readln().toString()
            if (classroom.searchForStudent(student)!= null){
                println("please enter the name of the course")
                val course = readln().toString()
                if (classroom.checkCourseName(course)!= null) {
                    classroom.enrollStudents(classroom.checkCourseName(course)!!,classroom.searchForStudent(student)!!)
                }else{
                    println("this course is not added please check the name or enter 3 to create the course")
                }


            }else{
                println(" Student name is not in the database ,please check the name or  enter 1 to add the student")
            }

            //        ------------------------------------------


        } else if (userChoice == 5) {
            classroom.listStudents()
            //        ------------------------------------------

        } else if (userChoice == 6) {
            classroom.listInstructors()
            //        ------------------------------------------

        } else if (userChoice == 7) {
            classroom.listCourses()
        }else if (userChoice !=8){
            println(" please check that the number you added")
        }
            //        ------------------------------------------

        if (userChoice != 8){
            println("please make a new choice or exit")
        }
    } while (userChoice != 8)
}
