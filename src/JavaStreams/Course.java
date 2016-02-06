package JavaStreams;

import java.io.*;

/**
 * Created by marin on 2/6/16.
 */
public class Course implements Serializable {

    private String courseName;
    private int numStudents;

    public Course(String name, int num) {
        courseName = name;
        numStudents = num;
    }

    public String getName() {
        return courseName;
    }

    public int getNum() {
        return numStudents;
    }

    public static void saveCourse(Course course) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/course.save"))) {
            oos.writeObject(course);
        }
        catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    public static void loadCourse() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res/course.save"))) {
            System.out.println(ois.readObject().toString());
        }
        catch (ClassNotFoundException | IOException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public String toString() {
        return "Course: \"" + this.getName() + "\"\nNumber of students: " + this.getNum();
    }

    public static void main(String[] args) {

        Course javaCourse = new Course("Introduction to Java", 24);

        saveCourse(javaCourse);
        loadCourse();
    }
}
