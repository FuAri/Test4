import cn.com.sise.pojo.Dept;
import cn.com.sise.pojo.Major;
import cn.com.sise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MajorTest {
    /**
     * 1.根据id查询专业信息
     */
    @Test
    public void findMajorByIdTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        Major major = sqlSession.selectOne("Mapper.MajorMapper.findMajorById", "1");
        // 打印输出结果
        //System.out.println(dept.toString());
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 2.添加专业
     */
    @Test
    public void addMajor(){
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        Major major = new Major();
        major.setMajorId("1");
        major.setMajorName("计算机");
        major.setTuition(24000);
        major.setDeptId(1);
        // 使用主键自助增长的添加方法
//		int rows = sqlSession.insert("com.sise.mapper."
//				+ "CustomerMapper.addCustomer", customer);
        // 使用自定义主键值的添加方法
        int rows = sqlSession.insert("Mapper.MajorMapper.addMajor", major);
        if(rows > 0){
            System.out.println("您成功插入了"+rows+"条数据！");
        }else{
            System.out.println("执行插入操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 3.更新专业
     */
    @Test
    public void updateMajorTest() throws Exception{
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行更新操作
        // 创建Customer对象，并向对象中添加数据
        Major major = new Major();
        major.setMajorId("1");
        major.setMajorName("软件");
        major.setTuition(25000);
        major.setDeptId(2);
        // 执行sqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("Mapper.MajorMapper.updateMajor", major);
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
     * 4.删除专业
     */
    @Test
    public void deleteMajorTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行删除操作
        // 执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("Mapper.MajorMapper.deleteMajor", 1);
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
