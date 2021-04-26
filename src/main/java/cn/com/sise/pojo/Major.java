package cn.com.sise.pojo;


/**
 * 专业类
 */
public class Major{

    private String majorId;//专业ID
    private String majorName;//专业
    private Integer tuition;//学费
    private Integer deptId;//系别ID
    public Major() {
    }

    public Major(String majorId) {
        this.majorId = majorId;
    }

    public Major(Integer deptId) {
        this.deptId = deptId;
    }

    public Major(String majorName, Integer deptId) {
        this.majorName = majorName;
        this.deptId = deptId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", tuition=" + tuition +
                ", deptId=" + deptId +
                '}';
    }
}