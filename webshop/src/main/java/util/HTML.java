package util;

import java.io.PrintWriter;

import java.util.List;

import data.Item;

public class HTML {
	public static void printStart(PrintWriter out) {
		out.println("<!DOCTYPE html><html><head><title>FishList</title></head><body>");
	}

	public static void printEnd(PrintWriter out) {
		out.println("</body></html>");
	}
	public static void printTable(PrintWriter out, List<Item> fishlist) {
		deleteScript(out);
		out.println("<h1>Fished fish</h1>");
		out.println("<table border='1'>");
		for (int i=0;i<fishlist.size();i++) {
			Item f=fishlist.get(i);
			out.println("<tr><td>"+f.getItemId()+"<td>"+f.getTitle()+"<td>"+f.getPrice()+
					"<td><a href='#' onclick='deleteFish("+f.getItemId()+");return false;'>Poista</a>");
		}
		out.println("</table>");
		out.println("<div id='loginout'>Log In Out</div>");
//		out.println("<a href='./index.html'>Back to form</a>");
	}
	private static void deleteScript(PrintWriter out) {
		
	    out.println("<script>\n"+
	    "function deleteFish(id){\n"+
	    	"window.alert(\"About to delete\");\n"+
	    	"xmlhttp = new XMLHttpRequest();\n"+
	    	"xmlhttp.onreadystatechange = function() {\n"+
	    	  "if (this.readyState == 4 && this.status == 200) {\n"+
//	    	    "window.alert(\"Deleted\"+this.responseText);\n"+
	    	    "document.getElementById('loginout').innerHTML=this.responseText;"+"\n"+
	    	  "}\n"+
	    	"};\n"+
	    	"xmlhttp.open(\"GET\", \"/rest/fishservice/deletefish/\"+id);\n"+
	    	"xmlhttp.send();\n"+    	
	    "}\n"+
	    "</script>\n");
	}
}
