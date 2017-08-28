/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icss.regie.weixin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Administrator
 */
public class ConfigServlet extends HttpServlet {
    private final String appid = "wx2a8339a6d2484a68";  
    private final String secret = "1ea99e515794a9be67d44aec4423d2bb";
    private final String url ="http://101.201.49.243/www/index.html";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try  {
            out = response.getWriter();
            AccessToken token = TokenUtils.getAccessToken(appid, secret);
            JsapiTicket ticket = TokenUtils.getJSApiTicket(token);
            WeixinSign sign = TokenUtils.getSign(url, ticket);
            sign.setAppId(appid);
            out.println("wx.config({");
            out.println("debug: true,");
            out.print("appId: '");
            out.print(appid);
            out.println("',");
            out.print("timestamp: '");
            out.print(sign.getTimestamp());
            out.println("',");
            out.print("nonceStr: '");
            out.print(sign.getNoncestr());
            out.println("',");
            out.print("signature: '");
            out.print(sign.getSignature());
            out.println("',");
            out.print("jsApiList: [");
            out.print("'chooseImage',");
            out.print("'previewImage',");
            out.print("'uploadImage',");
            out.print("'downloadImage',");
            out.print("'openLocation',");
            out.print("'scanQRCode',");
            out.print("'getLocation'");
            out.println("]");
            out.println(" });");
        }catch(Exception e){
            System.out.println(e);
        }finally {
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
