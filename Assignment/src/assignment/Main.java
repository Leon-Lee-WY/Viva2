package assignment;
public class Main {
    public static void main(String[] args) {
        //Create 2 lecture course and 2 lab course objects
        LectureCourse a=new LectureCourse("WIA1003", "Computer System Architecture", "Dr. Tey Kok Soon", 2);
        LectureCourse b=new LectureCourse("WIA1005", "Network Technology Foundation", "Dr. Faiz Zaki", 2);
        LabCourse x=new LabCourse("WIA1002", "Data Structure", "Dr. Zainab Malik", 3, 1);
        LabCourse y=new LabCourse("WIA1006", "Machine Learning", "Dr. Shapla", 1, 2);
        
        //course manager instance
        CourseManager first=new CourseManager();
        
        //add the course objects into course manager
        first.addCourse(a);
        first.addCourse(b);
        first.addCourse(x);
        first.addCourse(y);
        
        //print course with highest total workload
        System.out.println("===============================================");
        System.out.println("Detail of Course with Highest Total Workload");
        first.getCourseWithHighestWorkload().printCourseDetails();
        
        //sort using workload then print course detail
        System.out.println("===============================================");
        System.out.println("Detail of All Courses (sorted)");
        first.sortCoursesbyWorkload();
        first.printAllCourse();
        
        //remove a course then print
        System.out.println("===============================================");
        first.removeCourse("WIA1006");
        System.out.println("New Course Details");
        first.sortCoursesbyWorkload();
        first.printAllCourse();
    }
}
