/*
任务调度器
 */
package hot100.middle;

public class problem621 {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        problem621 a = new problem621();
        a.leastInterval(tasks, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        if (n==0) return tasks.length;



        return 1;
    }
}
