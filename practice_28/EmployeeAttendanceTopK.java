import java.util.*;

public class EmployeeAttendanceTopK {

    static class Employee {
        int id;
        int attendance;

        Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }
    }

    static int[] topK(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Employee[] arr = new Employee[n];
        for (int i = 0; i < n; i++) arr[i] = new Employee(employeeIds[i], attendance[i]);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                boolean swap = false;
                if (arr[j].attendance < arr[j + 1].attendance) swap = true;
                else if (arr[j].attendance == arr[j + 1].attendance && arr[j].id > arr[j + 1].id) swap = true;
                if (swap) {
                    Employee t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = arr[i].id;
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] ids = new int[n];
        int[] attendance = new int[n];
        for (int i = 0; i < n; i++) ids[i] = input.nextInt();
        for (int i = 0; i < n; i++) attendance[i] = input.nextInt();
        int k = input.nextInt();
        int[] ans = topK(ids, attendance, k);
        for (int i = 0; i < ans.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(ans[i]);
        }
    }
}

