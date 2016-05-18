/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.business.CourseRegistration;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Junwei
 */
public class DownloadController extends HttpServlet {

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
        
        String action = request.getParameter("action");
        if(action==null){
            action = "";
        }
        
        if(action.equals("course_spreadsheet")){
            downloadCourseSpreadsheet(request,response);
        }
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
        this.doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Download Course Spreadsheet Controller";
    }
    
    private void downloadCourseSpreadsheet(HttpServletRequest request, HttpServletResponse response){
        
        Workbook workbook = new HSSFWorkbook(); 
        Sheet sheet = workbook.createSheet("Course Table");
        Row row = sheet.createRow(0);
        row.createCell(2).setCellValue("Currently Course Enrollment Table");
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("Number");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Room");
        row.createCell(3).setCellValue("Instructor");
        row.createCell(4).setCellValue("Days&Time");
        row.createCell(5).setCellValue("Credit");
        row.createCell(6).setCellValue("Registration Time");
        
        HttpSession session = request.getSession();
        List<CourseRegistration> enrolled = (List<CourseRegistration>)session.getAttribute("enrolled");
        
        int i = 4;
        for(CourseRegistration cr : enrolled){
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(cr.getCourse().getCourseNum());
            row.createCell(1).setCellValue(cr.getCourse().getName());
            row.createCell(2).setCellValue(cr.getCourse().getRoom());
            row.createCell(3).setCellValue(cr.getCourse().getInstructor());
            row.createCell(4).setCellValue(cr.getCourse().getDt());
            row.createCell(5).setCellValue(cr.getCourse().getCredit() - '0');
            row.createCell(6).setCellValue(cr.getCourseRegisterationDateDefaultFormat());
            i++;
        }
        
        response.setHeader("content-disposition", "attachment; filename=CourseEnrollment.xls");
        response.setHeader("cache-control", "no-cache");
        
        try (OutputStream out = response.getOutputStream()) {
            workbook.write(out);
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }    
    }

}
