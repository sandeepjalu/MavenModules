package com.mycompany.prodcut.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mycompany.product.bo.ProductBO;
import com.mycompany.product.dto.Product;

/**
 * Servlet implementation class DisplayProductDetailsServlet
 */
public class DisplayProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this
                .getServletContext());
        ProductBO bo = (ProductBO) context.getBean("productbo");
        Product product = bo.findProduct(Integer.parseInt(request.getParameter("id")));

        PrintWriter out = response.getWriter();

        out.print("Product Details\n");
        out.print("Product ID:" + product.getId() + "\n");
        out.print("Product Name:" + product.getName() + "\n");
        out.print("Product Description:" + product.getDescription() + "\n");
        out.print("Product Price:" + product.getPrice() + "\n");

    }
}
