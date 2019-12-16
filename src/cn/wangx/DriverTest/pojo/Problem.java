package cn.wangx.DriverTest.pojo;

import java.io.Serializable;

public class Problem implements Serializable {
    private Long pid;
    private String content;
    private String chooseItem;
    private String result;
    private String type;
    private Integer pass;
    private Integer submit;
    private String img;
    private Integer mode;

    public Problem(Long pid, String content, String chooseItem, String result, String type, Integer pass, Integer submit, String img, Integer mode) {
        this.pid = pid;
        this.content = content;
        this.chooseItem = chooseItem;
        this.result = result;
        this.type = type;
        this.pass = pass;
        this.submit = submit;
        this.img = img;
        this.mode = mode;
    }

    public Problem() {
    }

    public Long getPid() {
        return pid;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChooseItem() {
        return chooseItem;
    }

    public void setChooseItem(String chooseItem) {
        this.chooseItem = chooseItem;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getSubmit() {
        return submit;
    }

    public void setSubmit(Integer submit) {
        this.submit = submit;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "pid=" + pid +
                ", content='" + content + '\'' +
                ", chooseItem='" + chooseItem + '\'' +
                ", result='" + result + '\'' +
                ", type='" + type + '\'' +
                ", pass=" + pass +
                ", submit=" + submit +
                ", img='" + img + '\'' +
                ", mode=" + mode +
                '}';
    }
}
