<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Hello App Engine</title>
    <script>
	    function readData(itemform){
	    	alert('readData()'); // if no alert pops up that means a bug in the JS code
	    	//var item = new Object();
	    	//item.itemId=itemform.itemid.value;
	    	
	    	//var x = JSON.stringify(item);
	    	var x = itemform.itemid.value
	    	xmlhttp = new XMLHttpRequest();
	    	xmlhttp.onreadystatechange = function() {
	    	  if (this.readyState == 4 && this.status == 200) {
	    		  	alert('OK: ' + 'this.readyState == 4 && this.status == 200');
					document.getElementById("getitem_result").innerHTML = this.responseText;
	    	  }
	    	};
	    	
	    	xmlhttp.open("GET", "./rest/itemservice/getjsonitemtoupdate/"+x, true);
	    	//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");	
	    	xmlhttp.send(x); // Sending the JSON to the service
	    	alert('var x = ' + x);
	    }
    
	    function sendData(itemform){
	    	alert('sendData()'); // if no alert pops up that means a bug in the JS code
	    	var item = new Object();
	    	/* *******************************************************************
	    		item.property -> has to be the same as in the data/object class!!!
	    	*********************************************************************/
	    	item.categoryId = itemform.categoryid.value;
	    	item.customerId = itemform.customerid.value;
	    	item.title = itemform.title.value;
	    	item.price = itemform.price.value;
	    	item.description = itemform.description.value;
	    	item.image = itemform.image.value;
	    	item.condition = itemform.condition.value;
	    	
	    	var x=JSON.stringify(item);
	    	
	    	xmlhttp = new XMLHttpRequest();
	    	xmlhttp.onreadystatechange = function() {
	    	//alert('this.readyState = ' + this.readyState);
	    	//alert('this.status = ' + this.status);
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
	    	var item = new Object();
	    	/* *******************************************************************
    		item.property -> has to be the same as in the data/object class!!!
    		*********************************************************************/
	    	item.itemId = itemform.itemid.value;
	    	item.categoryId = itemform.categoryid.value;
	    	item.customerId = itemform.customerid.value;
	    	item.title = itemform.title.value;
	    	item.price = itemform.price.value;
	    	item.description = itemform.description.value;
	    	item.image = itemform.image.value;
	    	item.condition = itemform.condition.value;
	    	
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
	    	var item = new Object();
	    	item.itemId=itemform.itemid.value;
	    	
	    	var x = JSON.stringify(item);
	    	
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
    
<h2>Read/Get all Item (0 -> JSON)</h2>
<a href='./rest/itemservice/getall'>Get all data from item table</a>
<p id='getall_result'>
results...
</p>

<h2>Read/Get an Item (JSON -> JSON)</h2>
<form id=formReadToUpdate action='' method='get'> <!-- for Delete use action='./rest/itemservice/deleteitem?id=1' method'POST' -->
	<input type='text' name='itemid' value='1'>
	<input type='button' name='ok' value='OK' onclick="readData(this.form)" ><br>
</form>
<p id='getitem_result'>
results...
</p>

<h2>Form parameters (urlencoded -> JSON)</h2>
	<form action='./rest/itemservice/additem' method='post'>
	CategoryId: <input type='text' name='categoryid' value='1'><br>
	CustomerId: <input type='text' name='customerid' value='2'><br>
	Title: <input type='text' name='title' value='some title'><br>
	Price: <input type='text' name='price' value='55'><br>
	Description: <input type='text' name='description' value='Chuck Norris'><br>
	Image: <input type='text' name='image' 
		value='image'><br>
	Condition: <input type='text' name='condition' value='used'><br>
	<input type='submit' name='ok' value='OK'><br>
	</form>

<h2>ADD JSON String (JSON -> JSON)</h2>
	<form id ='formJSON'action='./rest/itemservice/addjsonitem' method='post'>
	CategoryId: <input type='text' name='categoryid' value='1'><br>
	CustomerId: <input type='text' name='customerid' value='2'><br>
	Title: <input type='text' name='title' value='some title'><br>
	Price: <input type='text' name='price' value='55'><br>
	Description: <input type='text' name='description' value='Chuck Norris'><br>
	Image: <input type='text' name='image' 
		value='https://media.idownloadblog.com/wp-content/uploads/2012/03/Chuck-Norris-Angry-Siri-400x320.jpg'><br>
	Condition: <input type='text' name='condition' value='used'><br>
	<input type='button' name='ok' value='OK' onclick="sendData(this.form)" ><br>
	</form>
<p id='result'>
The result comes here
</p>

<h2>UPDATE JSON String (JSON -> JSON)</h2>
	<form id ='formJSONupdate'action='./rest/itemservice/updatejsonitem' method='post'>
	ItemId: <input type='text' name='itemid' value=''><br>
	CategoryId: <input type='text' name='categoryid' value='2'><br>
	CustomerId: <input type='text' name='customerid' value='6'><br>
	Title: <input type='text' name='title' value='new title'><br>
	Price: <input type='text' name='price' value='99.9'><br>
	Description: <input type='text' name='description' value='Steven Seagal'><br>
	Image: <input type='text' name='image' 
		value='https://images.wallpapersden.com/image/wxl-steven-seagal-brunette-face_53269.jpg'
		placeholder='https://images.wallpapersden.com/image/wxl-steven-seagal-brunette-face_53269.jpg'><br>
	Condition: <input type='text' name='condition' value='updated condition'><br>
	<input type='button' name='ok' value='OK' onclick="sendDataUpdate(this.form)" ><br>
	</form>
<p id='update_result'>
The result comes here
</p>

<h2>Delete JSON item (JSON -> JSON)</h2>
	<form id ='formJSONDelete'action='./rest/itemservice/deletejsonitem' method='get'>
	ItemId: <input type='text' name='itemid' value=''><br>
	<input type='button' name='ok' value='OK' onclick="deleteData(this.form)" ><br>
	</form>
<p id='delete_result'>
result: true or false
</p>
	
  </body>
</html>