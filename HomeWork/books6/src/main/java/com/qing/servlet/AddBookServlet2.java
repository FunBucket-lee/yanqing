package com.qing.servlet;

import com.qing.entity.Book;
import com.qing.service.BookService;
import com.qing.service.BookServiceImpl;
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
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AddBookServlet2", value = "/addBook2")
public class AddBookServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //判断表单是否支持文件上传。既：enctype="multipart/form-data"
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            throw new RuntimeException("表单必须设置为multipart/form-data类型");
        }

        //创建DiskFileItemFactory工厂类，用于创建ServletFileUpload对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //factory.getRepository(new File(D://temp);指定文件临时存储目录
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");

        Book book = new Book();

        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
            sfu.setFileSizeMax(500 * 1024);
            sfu.setSizeMax(1024 * 1024*2);
            HashMap<Object, Object> map = new HashMap<>();

            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    String fieldname = fileItem.getFieldName();
                    String fieldvalue = fileItem.getString("utf-8");
                    map.put(fieldname,fieldvalue);
//                    if (fieldname.equals("name")) {
//                        book.setName(fieldvalue);
//                    }
//                    if (fieldname.equals("pnum")) {
//                        book.setPnum(Integer.parseInt(fieldvalue));
//                    }
//                    if (fieldname.equals("price")) {
//                        book.setPrice(Double.parseDouble(fieldvalue));
//                    }
//                    if (fieldname.equals("description")) {
//                        book.setDescription(fieldvalue);
//                    }
//                    if (fieldname.equals("author")) {
//                        book.setAuthor(fieldvalue);
//                    }
//                    if (fieldname.equals("sales")) {
//                        book.setSales(Integer.parseInt(fieldvalue));
//                    }


                } else {
                    String uploadPath = this.getServletContext().getRealPath("/images");
                    System.out.println(uploadPath);

                    String filename = fileItem.getName();
                    filename = FilenameUtils.getName(filename);

                    File uploadfile = new File(uploadPath, filename);
                    fileItem.write(uploadfile);
//                    book.setImgurl(filename);
                    map.put("imgUrl",filename);
                }
            }
            BookService bookService = new BookServiceImpl();
//            bookService.addBook(book);
            bookService.addBook(map);
            response.sendRedirect("pageBooks");
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
