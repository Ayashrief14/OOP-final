class Classroom(
    var students: MutableList<Student>, var instructors: MutableList<Instructor>, var courses: MutableList<Course>
) {
    fun addStudent(studentName: Student): MutableList<Student> {
        students.add(studentName)
        println("Student added successfully ")
        return students
    }

    //    --------------------------------------------------------------
    fun addInstructor(instructorName: Instructor): MutableList<Instructor> {
        instructors.add(instructorName)
        println("instructor added successfully ")

        return instructors
    }

    //    ---------------------------------------------------------------
    fun createNewCourse(courseName: Course, instructorName: Instructor) {

        courses.add(courseName)
        instructorName.coursesTaught.add(courseName.courseName)
        println("course created successfully")
    }

    //    ----------------------------------------------------------------------
    fun enrollStudents(courseName: Course, studentName: Student): MutableList<Student> {
        courseName.students.add(studentName.name)
        println("student enrolled successfully")
        println()
        return students
    }

    //    ----------------------------------------------------------------------
    fun listStudents() {
        students.let {
            println("Students")
            it.forEach { student ->
                println(student.name)
            }
            println("-".repeat(10))
        }
    }
    //    ------------------------------------------------------------------------

    fun listInstructors() {
        instructors.let {
            println("instructors")
            it.forEach { instructor ->
                println(instructor.name)
            }
            println("-".repeat(10))
        }
    }
    //    -----------------------------------------------------------------------

    fun listCourses() {
        courses.let {
            println("courses")
            it.forEach { course ->
                println(course.courseName)
            }
            println("-".repeat(10))
        }
    }

    //    -------------------------------------------------------------------------
    fun searchForStudent(studentName: String): Student? {
        return students.find { it.name == studentName }
    }
    //    -------------------------------------------------------------------------

    fun checkCourseName(courseName: String): Course? {
        return courses.find { it.courseName == courseName }
    }
    //    -------------------------------------------------------------------------
    fun searchForInstructor(instructorName : String):Instructor?{
        return instructors.find { it.name == instructorName }
    }
}