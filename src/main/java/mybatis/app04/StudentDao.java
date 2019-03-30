package mybatis.app04;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import mybatis.util.MybatisUtil;

/**
 * 持久层
 * @author AdminTC
 */
public class StudentDao {
	/**
	 * 增加学生
	 */
	public void add1() throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			//事务开始（默认）
			//读取StudentMapper.xml映射文件中的SQL语句
			int i = sqlSession.insert("mybatis.app04.Student.add1");
			System.out.println("本次操作影响了"+i+"行");
			//事务提交
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//事务回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 增加学生
	 */
	public void add2(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			//事务开始（默认）
			//读取StudentMapper.xml映射文件中的SQL语句
			sqlSession.insert(Student.class.getName()+".add2",student);
			//事务提交
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//事务回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 增加学生
	 */
	public void add3(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert(Student.class.getName()+".add3",student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}

	/**
	 * 根据id删除记录
	 */
	public void deleteById(Integer id) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.delete(Student.class.getName() + ".delete", id);
			sqlSession.commit();
			System.out.println("delete success id = " + id);
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}

	/**
	 * 根据id删除记录
	 */
	public void update(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.update(Student.class.getName() + ".update" , student);
			sqlSession.commit();
			System.out.println("update success");
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}

	/**
	 * 查询所有的记录
	 */
	public void queryAll() throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			List<Student> students = sqlSession.selectList(Student.class.getName() + ".selectAll");
			sqlSession.commit();
			System.out.println("selectAll success");
			for(Student student : students){
				System.out.println(student.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}




}




