public class UniversityPersonStudentGradStudent {
    static class Person {
        String name;
        int personId;

        Person(String name, int personId) {
            this.name = name;
            this.personId = personId;
        }

        public String toString() {
            return "Person{name='" + name + "', personId=" + personId + "}";
        }
    }

    static class Student extends Person {
        final int studentId;
        double gpa;

        Student(String name, int personId, int studentId, double gpa) {
            super(name, personId);
            this.studentId = studentId;
            this.gpa = gpa;
        }

        public String toString() {
            return "Student{name='" + name + "', personId=" + personId + ", studentId=" + studentId + ", gpa=" + gpa + "}";
        }
    }

    static class GradStudent extends Student {
        String thesisTitle;

        GradStudent(String name, int personId, int studentId, double gpa, String thesisTitle) {
            super(name, personId, studentId, gpa);
            this.thesisTitle = thesisTitle;
        }

        public String toString() {
            return "GradStudent{name='" + name + "', personId=" + personId + ", studentId=" + studentId + ", gpa=" + gpa + ", thesisTitle='" + thesisTitle + "'}";
        }
    }

    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Asha", 501, 9001, 8.6, "AI for Healthcare");
        System.out.println(gs);
        System.out.println(gs.toString());

        Person p = gs;
        Student s = gs;
        System.out.println("GradStudent IS-A Student: " + (gs instanceof Student));
        System.out.println("Student IS-A Person: " + (s instanceof Person));
        System.out.println("GradStudent IS-A Person: " + (p instanceof Person));
    }
}

