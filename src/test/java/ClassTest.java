import cn.com.sise.pojo.Class;
import cn.com.sise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ClassTest {
    /**
     * 1.根据id查询班级信息
     */
    @Test
    public void findClassByIdTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        Class clss = sqlSession.selectOne("Mapper.ClassMapper.findClassById", 1);
        // 打印输出结果
        //System.out.println(dept.toString());
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 2.添加班级
     */
    @Test
    public void addClass(){
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        Class class1 = new Class();
        class1.setClassId(1);
        class1.setClassName("web3班");
        class1.setClassSize(60);
        class1.setClassSurplus(0);
        class1.setDeptId(1);
        class1.setMajorId("1");
        class1.setTutorId("1");
        class1.setInstructorId("1");
        class1.setBz("1");
        // 使用主键自助增长的添加方法
//		int rows = sqlSession.insert("com.sise.mapper."
//				+ "CustomerMapper.addCustomer", customer);
        // 使用自定义主键值的添加方法
        int rows = sqlSession.insert("Mapper.ClassMapper.addClass", class1);
        if(rows > 0){
            System.out.println("您成功插入了"+rows+"条数据！");
        }else{
            System.out.println("执行插入操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 3.更新班级
     */
    @Test
    public void updateClassTest() throws Exception{
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行更新操作
        // 创建Customer对象，并向对象中添加数据
        Class class1 = new Class();
        class1.setClassId(1);
        class1.setClassName("web4班");
        class1.setClassSize(59);
        class1.setClassSurplus(1);
        class1.setDeptId(1);
        class1.setMajorId("1");
        class1.setTutorId("1");
        class1.setInstructorId("1");
        class1.setBz("2");
        // 执行sqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("Mapper.ClassMapper.updateClass", class1);
        // 通过返回结果判断更新操作是否执行成功
        if(rows > 0){
            System.out.println("您成功修改了"+rows+"条数据！");
        }else{
            System.out.println("执行修改操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 4.删除班级
     */
    @Test
    public void deleteClassTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行删除操作
        // 执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("Mapper.ClassMapper.deleteClass", 1);
        // 通过返回结果判断删除操作是否执行成功
        if(rows > 0){
            System.out.println("您成功删除了"+rows+"条数据！");
        }else{
            System.out.println("执行删除操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }
}
