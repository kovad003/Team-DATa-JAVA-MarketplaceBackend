package app;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.utils.SystemProperty;

import conn.Connections;
import data.Item;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException {
	  doGet(request, response);
  }
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out=response.getWriter();
	    
	    String itemId = request.getParameter("itemid");
	    String customerId = request.getParameter("customerid");
	    String categoryId = request.getParameter("categoryid");
	    String title = request.getParameter("title");
	    String price = request.getParameter("price");
	    String description = request.getParameter("description");
	    String image = request.getParameter("image");
	    String condition = request.getParameter("condition");

	    
	    
	    
	    ArrayList<Item> itemlist=new ArrayList<>();
		util.HTML.printStart(out);
	    Connection conn=null;
	    if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {  
	    	out.println("Production version");
	    	try {
				conn=Connections.getProductionConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else {    
	    	out.println("Development version");
			try {
				conn=Connections.getDevConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    try {
	    	if (conn!=null) {
				Statement stmt=conn.createStatement();
				ResultSet RS=stmt.executeQuery("select * from item");
				
				while (RS.next()) {
					Item item=new Item();
					item.setItemId(RS.getInt("itemId"));
					item.setCategoryId(RS.getInt("categoryId"));
					item.setCustomerId(RS.getInt("customerId"));
					item.setTitle(RS.getString("title"));
					item.setPrice(RS.getString("price"));
					item.setDescription(RS.getString("description"));
					item.setImage(RS.getString("image"));
					item.setCondition(RS.getString("condition"));
					itemlist.add(item);
				}
				conn.close();
				util.HTML.printTable(out, itemlist);
	    	}
	    	else {
	    		out.println("No connection to database!");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.HTML.printEnd(out);
  }
}