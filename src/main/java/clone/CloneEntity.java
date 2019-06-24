package clone;

public class CloneEntity {

    public static void main(String[] args) throws CloneNotSupportedException {
        Entity entity1 = new Entity("zhoujinxin");
        Entity entity2 = (Entity)entity1.clone();
        System.out.println(entity1.getEntity());
        entity2.setEntity("linyaodong");
        System.out.println(entity2.getEntity());
        System.out.println(entity1.equals(entity2));
    }




}
