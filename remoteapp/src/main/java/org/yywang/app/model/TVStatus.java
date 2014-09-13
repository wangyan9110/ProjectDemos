package org.yywang.app.model;

/**
 * 电视状态
 */
public enum TVStatus {

    /**
     * 在线
     */
    online("在线"),

    /**
     * 离线
     */
    offline("离线");

    private String des;

    private TVStatus(String des){
        this.des=des;
    }

    public String getDes() {
        return des;
    }
}
