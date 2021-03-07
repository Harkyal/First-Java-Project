
package com.cestar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.ClientDao;

import com.cestar.model.Client;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//response.getWriter().append("Served at: ").append(request.getContextPath());
    String url = request.getServletPath();
   
    response.setContentType("text,html");
   
    PrintWriter out = response.getWriter();
   
    switch(url) {
   
    case "/display":{
   
    display(request,response);
   
    break;
    }
    case "/delete":{
    	   
        delete(request,response);
       
        break;
        }
   
    case "/edit":
    {
    edit(request,response);
    break;
   
    }
    case "/update":
    {
    update(request,response);
    break;
    }
    case "/insert":
    {
    insert(request,response);
    
    break;
   
    }
    default:{
    out.print("Sorry, the required page is not available..!!");
   
    }
   
    }
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//doGet(request, response);

ClientDao obj = new ClientDao();

List<Client> shippingrecords = obj.displayAllRecords();

HttpSession session = request.getSession();

session.setAttribute("clients_list", shippingrecords);

response.sendRedirect("display.jsp");



}

protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

ClientDao obj = new ClientDao();

int id = Integer.parseInt(request.getParameter("Client_ID"));

Client c = obj.getRecordById(id);

HttpSession session = request.getSession();

session.setAttribute("c", c);
session.setAttribute("old_id", id);

response.sendRedirect("update.jsp");




}
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	int u_id=Integer.parseInt(request.getParameter("c_ClientID"));
	String u_Contact=request.getParameter("c_Contact");
	String u_ItemShipped=request.getParameter("c_ItemShipped");
	String u_Date_Recieved=request.getParameter("c_Date_Recieved");
	String u_Date_Shipped=request.getParameter("c_Date_Shipped");
	
	
	Client updated_client=new Client(u_id,u_Contact,u_ItemShipped,u_Date_Recieved,u_Date_Shipped);
	HttpSession session=request.getSession();
	int old_id=(int)session.getAttribute("old_id");
	ClientDao obj=new ClientDao();
	obj.updateRecord(updated_client, old_id);
	display(request, response);
	
	
	
	}
protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int c_ClientID=Integer.parseInt(request.getParameter("Client_ID"));
	
	ClientDao obj=new ClientDao();
	obj.deleteRecord(c_ClientID);
	display(request, response);
	}
protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(request.getParameter("c_ClientID"));
	String Contact=request.getParameter("c_Contact");
	String ItemShipped=request.getParameter("c_ItemShipped");
	String Date_Recieved=request.getParameter("c_Date_Recieved");
	String Date_Shipped=request.getParameter("c_Date_Shipped");
	
	
	ClientDao obj =new ClientDao();
	obj.insert(id,Contact,ItemShipped,Date_Recieved,Date_Shipped);
	
	display(request, response);
	}

}