package com.example.car;

public class crs {
    String name;
    Double rate;
    Integer status;
    Integer pic;

    public crs(String name, Double rate, Integer status, Integer pic) {
        this.name = name;
        this.rate = rate;
        this.status = status;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPic() {
        return pic;
    }

    public void setPic(Integer pic) {
        this.pic = pic;
    }
}
