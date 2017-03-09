<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	
<p>bookName:javaEE</p>
<p>bookSize:4K</p>
<p>bookPrice:58</p>
<p>bookPages:1080</p>

		<input type="button" id="submit" value="Submit" />


<script type="text/javascript">
		$(function() { 
			$("#submit").click(function() {   
				var postdata = '{"bookName":"' + "javaEE" + '","bookSize":"' + "4K" +
				'","bookPrice":"' + "58"+'","bookPages":"' + "1080"+'"}';  
				//ajax 异步请求，发送数据给后端，后端在把数据传给前端
			    $.ajax({  
			        type : 'POST',  
			        contentType : 'application/json',  
			        url : 'http://localhost:8080/AjaxSend-Base/ajaxsendmodel',  
			        processData : false,  
			        dataType : 'json',  
			        
			       /*  data 存储数据发送给后端 */
			        data : postdata,  
			        success :  function(data) {  
			        	//接收后端发的数据内容，放在data中，只有当后端controllers中的
			        	//方法完整的运行结束之后才可以返回数据到data中
			            alert('打印成功'); 
			            console.log("bookName:"+data.bookName+"\nbookSize:"+data.bookSize+
			            		"\nbookPrice:"+data.bookPrice+"\nbookPages:"+data.bookPages);
			        },  
			        error : function() {  
			            alert('error...');  
			        } ,  
			       
			    }); 
			});
	    });
	</script> 
</body>
</html>