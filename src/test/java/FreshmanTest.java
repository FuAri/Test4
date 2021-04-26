import cn.com.sise.pojo.Freshman;
import cn.com.sise.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreshmanTest {
    @Test
    public void findFreshmanTest() {
        SqlSession session = MybatisUtils.getSession();
        Freshman freshman = new Freshman();
        freshman.setTicketNumber("18440882102025");
        freshman.setIdCard("440882199904090409");
//        freshman.setStuNo("");
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshman", freshman);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }

    @Test
    public void findFreshmanTest2() {
        SqlSession session = MybatisUtils.getSession();
        Freshman freshman = new Freshman();
        freshman.setTicketNumber("18440882102025");
        freshman.setIdCard("440882199904090409");
        freshman.setStuNo("");
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshman2", freshman);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }

    //    根据系别列表，获取对应的新生注册信息列表：参数为系id数组
    @Test
    public void findFreshmanByDeptId1Test() {
        SqlSession session = MybatisUtils.getSession();
        Integer[] deptIdArrays = {406,407};
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshmanByDeptId1", deptIdArrays);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }

    //    根据系别列表，获取对应的新生注册信息列表：参数为系id列表
    @Test
    public void findFreshmanByDeptId2Test() {
        SqlSession session = MybatisUtils.getSession();
        List<Integer> deptIdList = new ArrayList<>();
        deptIdList.add(406);
        deptIdList.add(407);
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshmanByDeptId2", deptIdList);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }

    //    根据专业列表，获取对应的新生注册信息列表：参数为专业id数组
    @Test
    public void findFreshmanByMajorId1Test() {
        SqlSession session = MybatisUtils.getSession();
        String[] majorIdArrays = {"06","07"};
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshmanByMajorId1", majorIdArrays);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }

    //    根据专业列表，获取对应的新生注册信息列表：参数为专业id列表
    @Test
    public void findFreshmanByMajorId2Test() {
        SqlSession session = MybatisUtils.getSession();
        List<String> majorIdList = new ArrayList<>();
        majorIdList.add("06");
        majorIdList.add("07");
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshmanByMajorId2", majorIdList);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }

    //    查询计算机系、计算机科学与技术专业、已注册的新生列表信息，多参数:封装成Map入参
    @Test
    public void findFreshmanByMapTest() {
        SqlSession session = MybatisUtils.getSession();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("deptId",406);
        List<String> majorIdList = new ArrayList<>();
        majorIdList.add("06");
        map.put("majorIds",majorIdList);
        map.put("status",1);
        List<Freshman> freshmans = session.selectList("Mapper.FreshmanMapper.findFreshmanByMap", map);
        for (Freshman freshman1 : freshmans) {
            System.out.println(freshman1);
        }
        session.close();
    }
}
