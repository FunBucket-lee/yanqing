package com.qing.servlet;

import com.qing.entity.Mobile;
import com.qing.service.MobileService;
import com.qing.service.MobileServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "AddMobileServlet", value = "/addMobile")
public class AddMobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            throw new RuntimeException("表单必须设置为multipart/form-data类型");
        }

        //创建DiskFileItemFactory工厂类，用于与创建ServletFileUpload对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建ServletFileUpload对象
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //解决表单乱码问题
        sfu.setHeaderEncoding("UTF-8");

        try {
            //可以设置文件大小
            sfu.setFileSizeMax(500 * 1024);//单个文件大小
            sfu.setSizeMax(1024 * 1024 * 2);//上传全部文件大小
            List<FileItem> fileItems = sfu.parseRequest(request);
            Mobile mobile = new Mobile();
            //变量表单项数据
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {//处理普通表单
                    String fieldName = fileItem.getFieldName();//字段名
                    String fieldValue = fileItem.getString("UTF-8");//字段值
                    if (fieldName.equals("brand")) {
                        mobile.setBrand(fieldValue);
                    }
                    if (fieldName.equals("type")) {
                        mobile.setType(fieldValue);
                    }
                    if (fieldName.equals("price")) {
                        mobile.setPrice(Double.valueOf(fieldValue));
                    }
                } else {//处理表单
                    //获取存储上传文件的目录绝对路径
                    String realPath = this.getServletContext().getRealPath("/images");
                    //获取存储上传文件的名字
                    String filename = fileItem.getName();
                    filename = FilenameUtils.getName(filename);

                    //根据文件目录和名字创建一个file对象
                    File file = new File(realPath, filename);

                    //上传文件，随后删除临时文件
                    fileItem.write(file);
                    mobile.setImageUrl(filename);
                    MobileService mobileService = new MobileServiceImpl();
                    mobileService.addMobile(mobile);
                    System.out.println(mobile + "=======================================");
                    response.sendRedirect("pageMobile");
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("errMsg", "单个文件不可超过500k");
            request.getRequestDispatcher("AddMobile.jsp").forward(request, response);
        } catch (FileUploadBase.SizeLimitExceededException e) {
            request.setAttribute("errMsg", "总文件不可超过2M");
            request.getRequestDispatcher("AddMobile.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
