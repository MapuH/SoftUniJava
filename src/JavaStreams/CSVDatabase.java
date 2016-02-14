package JavaStreams;

import com.sun.deploy.util.StringUtils;
import java.io.*;
import java.util.*;

/**
 * Created by marin on 2/9/16.
 */
public class CSVDatabase {

    private static final String STUDENTS_PATH = "res/students.txt";
    private static final String GRADES_PATH = "res/grades.txt";

    public static void fullNameSearch(String fullName) {
        try (
                BufferedReader studentsReader = new BufferedReader(new FileReader(STUDENTS_PATH));
                BufferedReader gradesReader = new BufferedReader(new FileReader(GRADES_PATH))
            ) {

            boolean foundMatch = false;

            String line = studentsReader.readLine();
            while (line != null) {
                String[] lineArgs = line.split(",");
                String name = lineArgs[1] + " " + lineArgs[2];
                int age = Integer.parseInt(lineArgs[3]);
                String town = lineArgs[4];

                if (fullName.equals(name)) {
                    foundMatch = true;
                    System.out.printf("%s (age: %d, town: %s)\n", name, age, town);

                    String gradesLine = gradesReader.readLine();
                    while (gradesLine != null) {
                        if (gradesLine.startsWith(lineArgs[0] + ",")) {
                            String[] gradeArgs = gradesLine.split(",");
                            for (int i = 1; i < gradeArgs.length ; i++) {
                                System.out.println("# " + gradeArgs[i]);
                            }
                        }
                        gradesLine = gradesReader.readLine();
                    }
                }
                line = studentsReader.readLine();
            }

            studentsReader.close();
            gradesReader.close();

            if (!foundMatch) {
                System.out.println("Student does not exist!");
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    public static void idSearch(int id) {
        try (
                BufferedReader studentsReader = new BufferedReader(new FileReader(STUDENTS_PATH));
                BufferedReader gradesReader = new BufferedReader(new FileReader(GRADES_PATH))
            ) {

            boolean foundMatch = false;
            String line = studentsReader.readLine();
            while (line != null) {
                if (line.startsWith(Integer.toString(id) + ",")) {
                    foundMatch = true;
                    String[] lineArgs = line.split(",");
                    String name = lineArgs[1] + " " + lineArgs[2];
                    int age = Integer.parseInt(lineArgs[3]);
                    String town = lineArgs[4];
                    System.out.printf("%s (age: %d, town: %s)\n", name, age, town);

                    String gradesLine = gradesReader.readLine();
                    while (gradesLine != null) {
                        if (gradesLine.startsWith(lineArgs[0] + ",")) {
                            String[] gradeArgs = gradesLine.split(",");
                            for (int i = 1; i < gradeArgs.length ; i++) {
                                System.out.println("# " + gradeArgs[i]);
                            }
                        }
                        gradesLine = gradesReader.readLine();
                    }

                }
                line = studentsReader.readLine();
            }

            studentsReader.close();
            gradesReader.close();

            if (!foundMatch) {
                System.out.println("Student does not exist!");
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    public static void idDelete(int id) {
        try (
                BufferedReader studentsReader = new BufferedReader(new FileReader(STUDENTS_PATH));
                BufferedReader gradesReader = new BufferedReader(new FileReader(GRADES_PATH))
            ) {

            boolean foundMatch = false;
            ArrayList<String> students = new ArrayList<>();
            ArrayList<String> grades = new ArrayList<>();

            String line = studentsReader.readLine();
            while (line != null) {

                if (line.startsWith((Integer.toString(id)) + ",")) {
                    foundMatch = true;
                } else {
                    students.add(line);
                }

                line = studentsReader.readLine();
            }
            studentsReader.close();

            String gradesLine = gradesReader.readLine();
            while (gradesLine != null) {

                if (!gradesLine.startsWith((Integer.toString(id)) + ",")) {
                    grades.add(gradesLine);
                }

                gradesLine = gradesReader.readLine();
            }
            gradesReader.close();

            if (foundMatch) {

                PrintWriter studentsWriter = new PrintWriter(STUDENTS_PATH);
                for (String student : students) {
                    studentsWriter.println(student);
                }
                studentsWriter.close();

                PrintWriter gradesWriter = new PrintWriter(GRADES_PATH);
                for (String grade : grades) {
                    gradesWriter.println(grade);
                }
                gradesWriter.close();

                System.out.printf("Student with id %d was successfully deleted", id);

            } else {
                System.out.println("Student does not exist!");
            }

        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    public static void idUpdate(int id) {
        try (
                BufferedReader studentsReader = new BufferedReader(new FileReader(STUDENTS_PATH));
                BufferedReader gradesReader = new BufferedReader(new FileReader(GRADES_PATH))
        ) {

            boolean foundMatch = false;
            Scanner update = new Scanner(System.in);
            ArrayList<String> students = new ArrayList<>();
            ArrayList<String> grades = new ArrayList<>();

            String line = studentsReader.readLine();
            while (line != null) {

                if (line.startsWith((Integer.toString(id)) + ",")) {
                    foundMatch = true;
                    System.out.println("Update student's details <first-name,family-name,age,town>:");
                    students.add(Integer.toString(id) + "," + update.nextLine());
                } else {
                    students.add(line);
                }

                line = studentsReader.readLine();
            }
            studentsReader.close();

            String gradesLine = gradesReader.readLine();
            while (gradesLine != null) {

                if (gradesLine.startsWith((Integer.toString(id)) + ",")) {
                    System.out.println("Update grades <course1 grades,course2 grades,courseN grades>:");
                    grades.add(Integer.toString(id) + "," + update.nextLine());
                } else {
                    grades.add(gradesLine);
                }

                gradesLine = gradesReader.readLine();
            }
            gradesReader.close();

            if (foundMatch) {

                PrintWriter studentsWriter = new PrintWriter(STUDENTS_PATH);
                for (String student : students) {
                    studentsWriter.println(student);
                }
                studentsWriter.close();

                PrintWriter gradesWriter = new PrintWriter(GRADES_PATH);
                for (String grade : grades) {
                    gradesWriter.println(grade);
                }
                gradesWriter.close();

                System.out.printf("Student with id %d was successfully updated", id);

            } else {
                System.out.println("Student does not exist!");
            }

        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    public static void insertStudent (String studentDetails) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_PATH));
                BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENTS_PATH, true))
            ) {

            List<Integer> idList = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                String[] lineArgs = line.split(",");
                idList.add(Integer.parseInt(lineArgs[0]));
                line = reader.readLine();
            }
            reader.close();

            int nextId;
            if (idList.isEmpty()) {
                nextId = 1;
            } else {
                nextId = Collections.max(idList) + 1;
            }

            line = studentDetails.replace(" ", ",");
            line = Integer.toString(nextId) + "," + line + "\n";
            writer.write(line);
            writer.close();

            System.out.println("Student was added with id " + nextId);
        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }

    }

    public static void insertGrade(int id, String subject, String grade) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_PATH));
                BufferedReader gradesReader = new BufferedReader(new FileReader(GRADES_PATH))
        ) {

            boolean foundMatch = false;
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith(Integer.toString(id) + ",")) {
                    foundMatch = true;
                    break;
                }
                line = reader.readLine();
            }
            reader.close();

            if (foundMatch) {

                ArrayList<String> gradesLines = new ArrayList<>();

                boolean gradeMatch = false;
                String gradesLine = gradesReader.readLine();
                while (gradesLine != null) {

                    if (gradesLine.startsWith(Integer.toString(id) + ",")) {

                        gradeMatch = true;
                        boolean subjectExists = false;
                        String[] gradesArgs = gradesLine.split(",");
                        for (int i = 1; i < gradesArgs.length ; i++) {
                            if (gradesArgs[i].startsWith(subject)) {
                                subjectExists = true;
                                gradesArgs[i] = gradesArgs[i] + " " + grade;
                            } else if ((i == gradesArgs.length - 1) && !subjectExists) {
                                gradesArgs[i] = gradesArgs[i] + "," + subject + " " + grade;
                            }
                        }

                        String editedLine = StringUtils.join(Arrays.asList(gradesArgs), ",");
                        gradesLines.add(editedLine);

                    } else {
                        gradesLines.add(gradesLine);
                    }

                    gradesLine = gradesReader.readLine();
                }
                gradesReader.close();

                if (!gradeMatch) {
                    gradesLines.add(Integer.toString(id) + "," + subject + " " + grade);
                }

                PrintWriter gradesWriter = new PrintWriter(GRADES_PATH);
                for (String row : gradesLines) {
                    gradesWriter.println(row);
                }
                gradesWriter.close();

                System.out.println("Grade added successfully!");

            } else {
                System.out.println("Student does not exist!");
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe.toString());
        }

    }

    public static void main(String[] args) {

        System.out.println("Welcome to the students database! Please, select a command:");
        System.out.println("1. Search by full name");
        System.out.println("2. Search by id");
        System.out.println("3. Delete by id");
        System.out.println("4. Update by id");
        System.out.println("5. Insert student");
        System.out.println("6. Insert grade by id");
        System.out.println();

        System.out.print("Your choice (1 - 6): ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.println("1. Search by full name".toUpperCase());
                System.out.println("Enter the student's name:");
                fullNameSearch(input.nextLine());
                break;
            case 2:
                System.out.println("2. Search by id".toUpperCase());
                System.out.println("Enter student's id:");
                idSearch(input.nextInt());
                break;
            case 3:
                System.out.println("3. Delete by id".toUpperCase());
                System.out.println("Enter student's id:");
                idDelete(input.nextInt());
                break;
            case 4:
                System.out.println("4. Update by id".toUpperCase());
                System.out.println("Enter student's id:");
                idUpdate(input.nextInt());
                break;
            case 5:
                System.out.println("5. Insert student".toUpperCase());
                System.out.println("Enter new student details <first-name family-name age town>:");
                insertStudent(input.nextLine());
                break;
            case 6:
                System.out.println("6. Insert grade by id".toUpperCase());
                System.out.println("Enter student's id, subject and grade <id subject grade>:");
                String[] inputArgs = input.nextLine().split(" ");
                insertGrade(Integer.parseInt(inputArgs[0]), inputArgs[1], inputArgs[2]);
                break;
            default:
                System.out.println("Please, choose 1 - 6");
                break;
        }

    }
}
