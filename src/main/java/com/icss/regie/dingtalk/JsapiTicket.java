/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icss.regie.dingtalk;

/**
 *
 * @author Administrator
 */
public class JsapiTicket {
    //错误代码
    private int errcode;
    //错误信息
    private String errmsg;
    //获取到的凭证
    private String ticket;
    //凭证有效时间，单位：秒
    private int expires_in;

    /**
     * @return the errcode
     */
    public int getErrcode() {
        return errcode;
    }

    /**
     * @param errcode the errcode to set
     */
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    /**
     * @return the errmsg
     */
    public String getErrmsg() {
        return errmsg;
    }

    /**
     * @param errmsg the errmsg to set
     */
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * @return the ticket
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the expires_in
     */
    public int getExpires_in() {
        return expires_in;
    }

    /**
     * @param expires_in the expires_in to set
     */
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
