<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery-1.4.4.min.js"></script>
<script type="text/javascript" >
 
   function load(){
	  
	   $.ajax({type:"POST",
			url:'log/index',
			data: {'user':$("#user").val(),'pwd':$("#pwd").val()},
			dataType:"json",
			success:function(data){
				alert(data.length);
			}
	    } 
	   );
   }
</script>
</head>
<body>
<h2>Hello World!</h2>
 <div>
 
  <form action="">
  
   user:<input type="text" id="user"/> <br/>
   pwd:<input type="text" id="pwd"/><br/>
   <button onclick="load();">asdasd</button>
  </form>
 
 
 </div>
</body>
</html>
