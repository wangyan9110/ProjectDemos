package org.yywang.spring;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main( String[] args ){
        new ClassPathXmlApplicationContext("classpath:spring_*.xml");
    }

}
