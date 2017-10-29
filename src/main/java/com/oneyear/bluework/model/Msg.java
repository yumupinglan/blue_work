/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.model;

/**
 * @ClassName Msg
 * @Description: TODO
 * @author wei
 * @Date: 2017年8月20日 
 */
public class Msg {
	private String title;
    private String content;
    private String etraInfo;

    public Msg(String title, String content, String etraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getEtraInfo() {
        return etraInfo;
    }
    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
