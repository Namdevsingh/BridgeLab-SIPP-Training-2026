public class EducationalCourseHierarchy {

    static class Course {
        String courseName;
        int duration;

        Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }

        void display() {
            System.out.print("Course: " + courseName + "\nDuration: " + duration + " months");
        }
    }

    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }

        void display() {
            System.out.print("Course: " + courseName + "\nDuration: " + duration + " months\nPlatform: " + platform + "\nRecorded: " + isRecorded);
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        void display() {
            double finalFee = fee - (fee * discount / 100.0);
            System.out.print("Course: " + courseName + "\nDuration: " + duration + " months\nPlatform: " + platform + "\nRecorded: " + isRecorded + "\nFee: " + fee + "\nDiscount: " + discount + "%\nFinal Fee: " + finalFee);
        }
    }

    public static void main(String[] args) {
        PaidOnlineCourse p = new PaidOnlineCourse("Java OOP", 4, "Coursera", true, 20000, 15);
        p.display();
    }
}

