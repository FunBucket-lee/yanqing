package com.qing.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UploadServlet", value = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            throw new RuntimeException("表单必须设置为multipart/form-data类型");
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");

        sfu.setFileSizeMax(500 * 1024);
        sfu.setSizeMax(1024 * 1024*2);
        try {
            List<FileItem> fileItems = sfu.parseRequest(request);

            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    String username = request.getParameter("username");
                    System.out.println("上传者" + username);
                    String age = request.getParameter("age");
                    System.out.println("上传者年龄" + age);
                    String fieldname = fileItem.getFieldName();
                    String fieldvalue = fileItem.getString("utf-8");

                    if (fieldname.equals("username")) {
                        System.out.println("新方法上传者username" + fieldname);
                        request.setAttribute("username", fieldvalue);
                    } else if (fieldname.equals("age")) {
                        System.out.println("新方法上传者年龄" + age);
                        request.setAttribute("age", fieldvalue);
                    }
                } else {
                    String uploadPath = this.getServletContext().getRealPath("/images");
                    System.out.println(uploadPath);

                    String filename = fileItem.getName();
                    filename = FilenameUtils.getName(filename);

                    File uploadfile = new File(uploadPath, filename);
                    fileItem.write(uploadfile);
                    request.setAttribute("filename", filename);
                }
            }
            request.getRequestDispatcher("Success.jsp").forward(request, response);
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("errMsg", "单个文件不可超过500k");
            request.getRequestDispatcher("Upload.jsp").forward(request, response);
        } catch (FileUploadBase.SizeLimitExceededException e) {
            request.setAttribute("errMsg", "总文件不可超过2M");
            request.getRequestDispatcher("Upload.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
