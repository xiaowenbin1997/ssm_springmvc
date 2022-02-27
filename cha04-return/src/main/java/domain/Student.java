package domain;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("student-init:no params 啊");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("student-setName 啊");
        this.name = name;
    }

    public Integer getAge() {
        System.out.println("student-setAge 啊");
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
