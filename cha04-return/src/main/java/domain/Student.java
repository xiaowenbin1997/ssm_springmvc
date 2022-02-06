package domain;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("student的无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("student的setName设置");
        this.name = name;
    }

    public Integer getAge() {
        System.out.println("student的setAge设置");
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
