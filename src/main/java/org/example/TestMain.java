package org.example;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class TestMain {
    public static void main(String[] args) {

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/app.xml"));

        Food f1 = factory.getBean("food", Food.class);
        Food f2 = factory.getBean("food", Food.class);

        System.out.println(f1);
        System.out.println(f2);

        f1.food("선배");
        f2.food("교수");

    }
}
