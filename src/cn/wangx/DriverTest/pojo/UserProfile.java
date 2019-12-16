package cn.wangx.DriverTest.pojo;

public class UserProfile {
    private String uid;
    private String realName;
    private int passNumber;
    private int failNumber;

    public UserProfile(String uid, String realName, int passNumber, int failNumber) {
        this.uid = uid;
        this.realName = realName;
        this.passNumber = passNumber;
        this.failNumber = failNumber;
    }

    public UserProfile() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public int getFailNumber() {
        return failNumber;
    }

    public void setFailNumber(int failNumber) {
        this.failNumber = failNumber;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "uid='" + uid + '\'' +
                ", realName='" + realName + '\'' +
                ", passNumber=" + passNumber +
                ", failNumber=" + failNumber +
                '}';
    }
}
