package reflection;

public class Reflection {

    public void print(){
        System.out.println("hello word!");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("reflection.Reflection");
        Reflection re = (Reflection)clazz.newInstance();
        re.print();
    }
}
