package cn.com.sise.pojo;

/**
 * 系别类
 */
public class Dept{
    private Integer deptId;//系别ID
    private String deptname;//系名
    public Dept() {

    }

    public Dept(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptname='" + deptname + '\''+"}";
    }
}