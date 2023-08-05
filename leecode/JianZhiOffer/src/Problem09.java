import java.util.Stack;

public class Problem09 {
    public static void main(String[] args) {
        Problem09 problem09 = new Problem09();
        CQueue cQueue = problem09.new CQueue();
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    /**
     * 一个栈用来存数据，一个栈用来出数据
     * 当删除数据的时候直接从出数据的栈出，当出数据的栈为空的时候将存数据的栈中的所有数据全部移到出数据的栈中
     */
    class CQueue {
        Stack<Integer> saveData = new Stack(); // 保存数据的栈
        Stack<Integer> deleteData = new Stack(); // 删除数据的栈
        public CQueue() {
        }

        public void appendTail(int value) {
            saveData.push(value);
        }

        public int deleteHead() {
            if (saveData.isEmpty() && deleteData.isEmpty()){
                return -1;
            } else if (deleteData.isEmpty()) {
                while (!saveData.isEmpty()){
                    deleteData.push(saveData.pop());
                }
            }
            return deleteData.pop();
        }
    }

}
