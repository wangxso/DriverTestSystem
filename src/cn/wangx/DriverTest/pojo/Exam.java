package cn.wangx.DriverTest.pojo;

public class Exam {
    private String uid;
    private int pass;
    private int fail;
    private String pid_list;
    private String date;

    public Exam(String uid, int pass, int fail, String pid_list,String date) {
        this.uid = uid;
        this.pass = pass;
        this.fail = fail;
        this.pid_list = pid_list;
        this.date = date;
    }

    public Exam() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public String getPid_list() {
        return pid_list;
    }

    public void setPid_list(String pid_list) {
        this.pid_list = pid_list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "uid='" + uid + '\'' +
                ", pass=" + pass +
                ", fail=" + fail +
                ", pid_list='" + pid_list + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
