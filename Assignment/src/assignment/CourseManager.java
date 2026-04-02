package assignment;
import java.util.ArrayList;
public class CourseManager<T extends Course> {
    ArrayList<T> courses;
    CourseManager(){
        courses=new ArrayList<>(); //create new object everytime coursemanager called
    }
    public void addCourse(T course){
        courses.add(course);
    }
    public void removeCourse(String courseCode){
        for (int i=0;i<courses.size();i++){
            if (courses.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {
                courses.remove(i);
                break;
            }
        }
    }
    public T getCourseWithHighestWorkload(){
        if (courses.isEmpty()){
            return null;  //unable to compare, return nothing
        } 
        T high=courses.get(0);  //set the object as the one with highest total workload
        for (T x:courses) {
            if (x.calculateTotalWorkload()>high.calculateTotalWorkload()) {
                high=x;
            }
        }
        return high;  //return the object
    }
    
    public void sortCoursesbyWorkload(){
        for(int i=0;i<courses.size()-1;i++){
            for(int j=0;j<courses.size()-1-i;j++){ //-i because i elements at the end is well sorted, leave them out
                if(courses.get(j).calculateTotalWorkload()>courses.get(j+1).calculateTotalWorkload()){
                    T temp=courses.get(j); //store j element in temp, replace j with j+1,replace j +1 with temp
                    courses.set(j, courses.get(j+1));
                    courses.set(j+1, temp);
                }
            }
        }
    }
    public void printAllCourse(){
        for(T x:courses){
            x.printCourseDetails();
            System.out.println("");
        }
    }
}
