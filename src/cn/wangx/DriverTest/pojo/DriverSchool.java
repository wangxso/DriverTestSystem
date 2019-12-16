package cn.wangx.DriverTest.pojo;

public class DriverSchool {
    private Integer sid;
    private String title;
    private Integer price;
    private String address;
    private String phone;
    private String city;
    private String src;

    public DriverSchool(Integer sid, String title, Integer price, String address, String phone, String city, String src) {
        this.sid = sid;
        this.title = title;
        this.price = price;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.src = src;
    }

    public DriverSchool() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "DriverSchool{" +
                "sid=" + sid +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
