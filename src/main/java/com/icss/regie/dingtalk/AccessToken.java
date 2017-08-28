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
public class AccessToken {
/**
     * 错误时返回前两个参数，{"errcode":40013,"errmsg":"invalid appid"}
     * 正确时返回后面两个参数，{"access_token":"ACCESS_TOKEN","expires_in":7200}
     * 
     */
    //错误代码
    private int errcode;
    //错误信息
    private String errmsg;
    //获取到的凭证
    private String access_token;
     
    public int getErrcode() {
        return errcode;
    }
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getAccess_token() {
        return access_token;
    }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
