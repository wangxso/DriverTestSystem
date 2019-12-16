package cn.wangx.DriverTest.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String uid;
    private String username;
    private String password;
    private String role;
    private String rid;
    private String createDate;
    private String updateDate;

    public User(String uid, String username, String password, String role, String rid, String createDate, String updateDate) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.rid = rid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public User(String uid, String username, String password, String role, String rid) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.rid = rid;
    }

    public User(String uid, String username, String password, String role) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User){
            User user = (User) obj;
            return this.getUsername().equals(user.getUsername());
        }
        return false;
    }
}
