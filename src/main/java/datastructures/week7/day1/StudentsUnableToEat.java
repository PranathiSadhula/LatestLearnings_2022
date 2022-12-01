package datastructures.week7.day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StudentsUnableToEat {
    /**
     * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/submissions/
     *
     * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
     *
     * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
     *
     * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
     * Otherwise, they will leave it and go to the queue's end.
     * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
     *
     * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
     *
     *
     *
     * Example 1:
     *
     * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
     * Output: 0
     * Explanation:
     * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
     * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
     * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
     * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
     * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
     * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
     * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
     * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
     * Hence all students are able to eat.
     * Example 2:
     *
     * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
     * Output: 3
     *
     *
     * Constraints:
     *
     * 1 <= students.length, sandwiches.length <= 100
     * students.length == sandwiches.length
     * sandwiches[i] is 0 or 1.
     * students[i] is 0 or 1.
     *
     */


    /**
     *
     */

    private int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) stack.push(sandwiches[i]);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int st : students) queue.add(st);
        int count = 0;
        int movements = 0;
        while (!stack.isEmpty()) { //
            if (!stack.isEmpty() && !queue.isEmpty()) {
                if (stack.peek() == queue.peek()) {
                    stack.pop();
                    queue.remove();
                    count++;
                } else {
                    int studToMoveback = queue.remove();
                    queue.add(studToMoveback);
                    movements++;
                    if (movements > queue.size()) break;
                }
            }

        }

        return students.length - count;
    }

    @Test
    public void test() {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        Assert.assertEquals(0, countStudents(students, sandwiches));
    }

    @Test
    public void test1() {
        int[] students = {1, 1, 1, 0, 1};
        int[] sandwiches = {0, 1, 0, 1, 1};
        Assert.assertEquals(3, countStudents(students, sandwiches));
    }

    @Test
    public void test2() {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        Assert.assertEquals(0, countStudents(students, sandwiches));
    }


    private int countStudentsQue(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int st : students) queue.add(st);
        int movements = 0;
        int sindx = 0;
        while (movements < queue.size()) {

            if (queue.peek() == sandwiches[sindx]) {
                queue.remove();
                movements = 0;
                sindx++;

            } else {
                int studToMoveback = queue.remove();
                queue.add(studToMoveback);
                movements++;
            }

        }

        return queue.size();
    }


}