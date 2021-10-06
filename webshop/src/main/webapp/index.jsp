<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Hello App Engine</title>
    <script>
	    function sendData(itemform){
	    	alert('sendData()'); // if no alert pops up that means a bug in the JS code
	    	var item=new Object();
	    	item.name=itemform.name.value;
	    	item.price=itemform.price.value;
	    	item.description=itemform.description.value;
	    	item.category=itemform.category.value;
	    	
	    	var x=JSON.stringify(item);
	    	
	    	xmlhttp = new XMLHttpRequest();
	    	xmlhttp.onreadystatechange = function() {
	    	  if (this.readyState == 4 && this.status == 200) {
	    		  	alert('OK: ' + 'this.readyState == 4 && this.status == 200');
					document.getElementById("result").innerHTML = this.responseText; // Will grab the HTML element identified by the result ID and prints the response there
	    	  }
	    	};
	    	xmlhttp.open("POST", "./rest/itemservice/addjsonitem", true);
	    	xmlhttp.setRequestHeader("Content-type", "application/json");	
	    	xmlhttp.send(x); // Sending the JSON to the service
	    	alert('item x = ' + x);
	    }
	    
	    function sendDataUpdate(itemform){
	    	alert('sendDataUpdate()'); // if no alert pops up that means a bug in the JS code
	    	var item=new Object();
	    	item.id=itemform.id.value;
	    	item.name=itemform.name.value;
	    	item.price=itemform.price.value;
	    	item.description=itemform.description.value;
	    	item.category=itemform.category.value;
	    	
	    	var x=JSON.stringify(item);
	    	
	    	xmlhttp = new XMLHttpRequest();
	    	xmlhttp.onreadystatechange = function() {
	    	  if (this.readyState == 4 && this.status == 200) {
	    		  	alert('OK: ' + 'this.readyState == 4 && this.status == 200');
					document.getElementById("update_result").innerHTML = this.responseText; // Will grab the HTML element identified by the result ID and prints the response there
	    	  }
	    	};
	    	xmlhttp.open("PUT", "./rest/itemservice/updatejsonitem", true);
	    	xmlhttp.setRequestHeader("Content-type", "application/json");	
	    	xmlhttp.send(x); // Sending the JSON to the service
	    	alert('item x = ' + x);
	    }
	    
	    function deleteData(itemform){
	    	alert('deleteData()'); // if no alert pops up that means a bug in the JS code
	    	var item=new Object();
	    	item.id=itemform.id.value;
	    	
	    	var x=JSON.stringify(item);
	    	
	    	xmlhttp = new XMLHttpRequest();
	    	xmlhttp.onreadystatechange = function() {
	    	  if (this.readyState == 4 && this.status == 200) {
	    		  	alert('OK: ' + 'this.readyState == 4 && this.status == 200');
					document.getElementById("delete_result").innerHTML = this.responseText;
	    	  }
	    	};
	    	xmlhttp.open("DELETE", "./rest/itemservice/deletejsonitem", true);
	    	xmlhttp.setRequestHeader("Content-type", "application/json");	
	    	xmlhttp.send(x); // Sending the JSON to the service
	    	alert('item x = ' + x);
	    }

    </script>
  </head>

  <body>
    <h1>Hello App Engine!</h1>

<h2>Form parameters -- working</h2>
	<form action='./rest/itemservice/additem' method='post'>
	Name: <input type='text' name='name' value=''><br>
	Price: <input type='text' name='price' value=''><br>
	Description: <input type='text' name='description' value=''><br>
	Category: <input type='text' name='category' value=''><br>
	<input type='submit' name='ok' value='OK'><br>
	</form>

<h2>ADD JSON String -- working</h2>
	<form id ='formJSON'action='./rest/itemservice/addjsonitem' method='post'>
	Name: <input type='text' name='name' value=''><br>
	Price: <input type='text' name='price' value=''><br>
	Description: <input type='text' name='description' value=''><br>
	Category: <input type='text' name='category' value=''><br>
	<input type='button' name='ok' value='OK' onclick="sendData(this.form)" ><br>
	</form>
<p id='result'>
The result comes here
</p>

<h2>UPDATE JSON String -- working</h2>
	<form id ='formJSONupdate'action='./rest/itemservice/updatejsonitem' method='post'>
	Id: <input type='text' name='id' value=''><br>
	Name: <input type='text' name='name' value=''><br>
	Price: <input type='text' name='price' value=''><br>
	Description: <input type='text' name='description' value=''><br>
	Category: <input type='text' name='category' value=''><br>
	<input type='button' name='ok' value='OK' onclick="sendDataUpdate(this.form)" ><br>
	</form>
<p id='update_result'>
The result comes here
</p>

<h2>Delete JSON item -- working</h2>
	<form id ='formJSONDelete'action='./rest/itemservice/deletejsonitem' method='get'>
	Id: <input type='text' name='id' value=''><br>
	<input type='button' name='ok' value='OK' onclick="deleteData(this.form)" ><br>
	</form>
<p id='delete_result'>
No results here
</p>
	

<h2>Delete Item -- not working...</h2>
<form action='./rest/itemservice/deleteitem?id=1' method='get'> <!-- for Delete use action='./rest/itemservice/deleteitem?id=1' method'POST' -->
	<input type='submit' name='id' value='1'>
	<input type='submit' name='ok' value='DELETE'>
</form>
<a href='./rest/itemservice/deleteitem?id=1'>'./rest/itemservice/deleteitem?id=1'</a>
  </body>
</html>