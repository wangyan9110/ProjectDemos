package org.yywang.app.framework.utils;

/**
 * 调用顺序
 */
public enum CallingLogger {

    instance;

    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * 计数
     */
    private Integer number = 1;

    /**
     * 添加
     *
     * @param text text
     */
    public CallingLogger append(String text) {
        number++;
        stringBuilder.append("-->").append(number + ".").append(text);
        return this;
    }

    /**
     * 开始
     */
    public CallingLogger start() {
        stringBuilder = new StringBuilder();
        number = 1;
        stringBuilder.append(number + ".").append("App.main");
        return this;
    }

    /**
     * 打印
     */
    public void print() {
        PrintUtils.println("调用顺序："+stringBuilder.toString());
    }
}
