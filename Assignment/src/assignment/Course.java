package assignment;
public interface Course {
    /**
     * @return the course's unique code
     */
    public String getCourseCode();
    
    /**
     * @return  the course's title
     */
    public String getCourseTitle();
    
    /**
     * @return the total workload hours for the course per semester
     */
    public int calculateTotalWorkload();
    
    /**
     * @return  the name of the assigned instructor.
     */
    public String getInstructorName();
    
    /**
     * @prints all relevant information about the course
     */
    public void printCourseDetails();
}
