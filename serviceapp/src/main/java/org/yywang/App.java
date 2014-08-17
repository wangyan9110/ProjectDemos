package org.yywang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext apx = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        Demo demo = (Demo)apx.getBean("demo");
        demo.say();
    }
}
