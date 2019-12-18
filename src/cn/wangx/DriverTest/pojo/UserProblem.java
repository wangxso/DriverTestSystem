package cn.wangx.DriverTest.pojo;

public class UserProblem {
    private String uid;
    private int pid;
    private int status;
    private int type;
    private int mode;

    public UserProblem() {
    }

    public UserProblem(String uid, int pid, int status) {
        this.uid = uid;
        this.pid = pid;
        this.status = status;
    }

    public UserProblem(String uid, int pid, int status, int type, int mode) {
        this.uid = uid;
        this.pid = pid;
        this.status = status;
        this.type = type;
        this.mode = mode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "UserProblem{" +
                "uid='" + uid + '\'' +
                ", pid=" + pid +
                ", status=" + status +
                ", type=" + type +
                ", mode=" + mode +
                '}';
    }

}
