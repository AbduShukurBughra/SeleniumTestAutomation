package com.seleniummaster.classtutorial.cubecarttest;

public class Product {
    private boolean status;
    private String name;
    private String condition;
    private String code;

    public Product() {
    }

    public Product(boolean status, String name, String condition, String code) {
        this.status = status;
        this.name = name;
        this.condition = condition;
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
