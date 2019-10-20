
<%@ page contentType="text/html" pageEncoding="GBK"%>
 <script src="jquery-1.10.2.min.js" type="text/javascript"></script>
<html>
	<head>
		<title>提交截图</title>
	</head>
	  <style>
  	.div1{
  		margin:10% 35%;
  		padding:20px;
  		border:2px solid red;
  	}
  	
  </style>
	<body>
		<h1>上传文件的主名要求：必须使用本人的正确的姓名！必须上传自己的截图！！！</h1>
		<div class="div1">
			<form method="post" action="upload"  enctype="multipart/form-data"
				name="form1">
				姓名：<input type="text" name="stuname" id="name"><br><br>
				<input type="file" name="file1" contenteditable="false"
					onclick="info.innerHTML=''" />
				<br/><br>
				
				<input type="submit" value="上传" />
			</form>
			<div id="info">
				${message}
			</div>		
			
		</div>
		
	
	</body>
</html>