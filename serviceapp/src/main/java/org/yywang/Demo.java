package org.yywang;

import javax.annotation.Resource;

/**
 * @author yywang
 */
public class Demo {

    @Resource
    private String text;

    public void say() {
        System.out.println("say:" + text);
    }
}
