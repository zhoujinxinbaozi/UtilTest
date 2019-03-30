package mybatis.app04;

public class App {
    public static void main(String[] args) throws Exception{
        StudentDao dao = new StudentDao();
//        dao.add1();
//        dao.deleteById(1);
        dao.queryAll();
        Student student = new Student();
        student.setId(1);
        student.setName("武圣人于和");
//        dao.update(student);
//		dao.add2(new Student(2,"呵呵",8000D));
//		dao.add3(new Student(3,"嘻嘻",9000D));
//		dao.add3(new Student(4,"笨笨",9000D));
    }
}
