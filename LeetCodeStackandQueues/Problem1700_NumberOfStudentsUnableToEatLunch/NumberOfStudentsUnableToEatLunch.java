package Problem1700_NumberOfStudentsUnableToEatLunch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int s : students) q.offer(s);

        int index = 0; // pointer for sandwiches
        int rotations = 0;

        while (!q.isEmpty() && rotations < q.size()) {
            if (q.peek() == sandwiches[index]) {
                q.poll();
                index++;
                rotations = 0;
            } else {
                q.offer(q.poll());
                rotations++;
            }
        }

        return q.size();
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch solution = new NumberOfStudentsUnableToEatLunch();

        int[] students1 = {1,1,0,0};
        int[] sandwiches1 = {0,1,0,1};
        System.out.println(solution.countStudents(students1, sandwiches1)); // expected 0

        int[] students2 = {1,1,1,0,0,1};
        int[] sandwiches2 = {1,0,0,0,1,1};
        System.out.println(solution.countStudents(students2, sandwiches2)); // expected 3
    }
}
