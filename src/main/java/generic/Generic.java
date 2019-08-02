package generic;

public class Generic<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Generic<String> generic1 = new Generic<String>();
        generic1.setT("123");
        System.out.println(generic1.getT());

        Generic<Integer> generic2 = new Generic<Integer>();
        generic2.setT(10000);
        System.out.println(generic2.getT());
    }


}
