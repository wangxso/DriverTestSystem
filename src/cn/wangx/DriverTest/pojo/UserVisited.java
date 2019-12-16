package cn.wangx.DriverTest.pojo;

public class UserVisited {
    private String username;
    private String ip;
    private String browser;
    private String date;

    public UserVisited() {
    }

    public UserVisited(String username, String ip, String browser, String date) {
        this.username = username;
        this.ip = ip;
        this.browser = browser;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserVisited{" +
                "username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", browser='" + browser + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
