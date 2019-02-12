package coding;

import java.util.Stack;

public class RemoveLast {
    private static Stack<Integer> stack;

    public RemoveLast(){
        stack = new Stack<Integer>();
    }

    /***
     * 获得并移除栈中的最后一个元素
     * @return
     */
    private Integer getAndRemoveLastElement(){
        if(stack.size() == 1){
            return stack.pop();
        }else{
            Integer tmp = stack.pop();
            Integer last = getAndRemoveLastElement();
            stack.push(tmp);
            return last;
        }
    }

    public static void main(String[] args) {
        RemoveLast rl = new RemoveLast();
        rl.initStack();
        rl.print();
        rl.initStack();
//        for(int i = 0; i < stack.size(); i ++){
//            System.out.println(rl.getAndRemoveLastElement());
//        }
        System.out.println("********* reverse **********");
        while(!stack.isEmpty()){
            System.out.println(rl.getAndRemoveLastElement());
        }
    }

    private void print() {
        System.out.println("******** original ********");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private void initStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }


}
