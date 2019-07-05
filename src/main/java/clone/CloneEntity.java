package clone;

public class CloneEntity {

    public static void main(String[] args) throws CloneNotSupportedException {
        Entity entity1 = new Entity("zhoujinxin");
        Entity entity2 = (Entity)entity1.clone();
        System.out.println(entity1.getEntity());
        entity2.setEntity("zhoujinxin");
        System.out.println(entity2.getEntity());
        System.out.println(entity1.equals(entity2));
        System.out.println(entity1 == entity2);
        System.out.println("entity2.hashCode() = " + entity1.hashCode() + "\t\t entity2.hashCode() = " + entity2.hashCode());
        System.out.println((Integer.MAX_VALUE + 1) ==  Integer.MIN_VALUE);
    }




}
