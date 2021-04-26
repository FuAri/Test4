import cn.com.sise.pojo.Dept;
import cn.com.sise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeptTest {
    /**
     * 1.根据id查询部门信息
     */
    @Test
    public void findDeptByIdTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        Dept dept = sqlSession.selectOne("Mapper.DeptMapper.findDeptById", 1);
        // 打印输出结果
        System.out.println(dept.toString());
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 1.1根据名字模糊查询
     */
    @Test
    public void findDeptByNameTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Dept> list = sqlSession.selectList("Mapper.DeptMapper.findDeptByName", "三");
        // 打印输出结果
        for(Dept dept:list){
            System.out.println(dept.toString());
        }
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 2.添加部门
     */
    @Test
    public void addDept(){
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        Dept dept = new Dept();
        dept.setDeptId(3);
        dept.setDeptname("student");
        // 使用主键自助增长的添加方法
//		int rows = sqlSession.insert("com.sise.mapper."
//				+ "CustomerMapper.addCustomer", customer);
        // 使用自定义主键值的添加方法
        int rows = sqlSession.insert("Mapper.DeptMapper.addDept", dept);
        if(rows > 0){
            System.out.println("您成功插入了"+rows+"条数据！");
        }else{
            System.out.println("执行插入操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 3.更新部门
     */
    @Test
    public void updateDeptTest() throws Exception{
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行更新操作
        // 创建Customer对象，并向对象中添加数据
        Dept dept = new Dept();
        dept.setDeptId(3);
        dept.setDeptname("李四");
        // 执行sqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("Mapper.DeptMapper.updateDept", dept);
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
     * 4.删除部门
     */
    @Test
    public void deleteDeptTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行删除操作
        // 执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("Mapper.DeptMapper.deleteDept", 3);
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
