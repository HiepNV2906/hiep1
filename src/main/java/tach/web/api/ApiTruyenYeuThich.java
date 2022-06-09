/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tach.web.api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tach.web.dao.YeuThichDao;
import tach.web.model.Sach;
import tach.web.model.YeuThich;

/**
 *
 * @author BV LAPTOP
 */
@WebServlet(urlPatterns="/api/truyenyeuthich/")
public class ApiTruyenYeuThich extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        ArrayList<Sach> ythList =new YeuThichDao().getSachYeuThich(1);
        String jsonString = new Gson().toJson(ythList);
        printWriter.write(jsonString); 
        printWriter.close();

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        try {
            BufferedReader reader=req.getReader();
            getRequestBody request=new getRequestBody();
            String jsonString=request.getBody(reader);
            YeuThich ythThich=new Gson().fromJson(jsonString, YeuThich.class);
            System.out.println(ythThich);
            YeuThichDao ythd = new YeuThichDao();
            ythd.insertYeuThich(ythThich);
            printWriter.print(jsonString);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        try {
            BufferedReader reader=req.getReader();
            getRequestBody request=new getRequestBody();
            String jsonString=request.getBody(reader);
            YeuThich ythThich=new Gson().fromJson(jsonString, YeuThich.class);
            System.out.println(ythThich);
            YeuThichDao ythd = new YeuThichDao();
            ythd.deleteYeuThich(ythThich);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
}
