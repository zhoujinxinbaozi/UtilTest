package spring.ioc;

public class HelloWorld1 {
   private String text;

   public String getText() {
      System.out.println(text);
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public void init(){
      System.out.println("init helloWord1");
   }
   public void destroy(){
      System.out.println("destroy helloword1");
   }
}