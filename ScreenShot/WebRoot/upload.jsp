
<%@ page contentType="text/html" pageEncoding="GBK"%>
 <script src="jquery-1.10.2.min.js" type="text/javascript"></script>
<html>
	<head>
		<title>�ύ��ͼ</title>
	</head>
	  <style>
  	.div1{
  		margin:10% 35%;
  		padding:20px;
  		border:2px solid red;
  	}
  	
  </style>
	<body>
		<h1>�ϴ��ļ�������Ҫ�󣺱���ʹ�ñ��˵���ȷ�������������ϴ��Լ��Ľ�ͼ������</h1>
		<div class="div1">
			<form method="post" action="upload"  enctype="multipart/form-data"
				name="form1">
				������<input type="text" name="stuname" id="name"><br><br>
				<input type="file" name="file1" contenteditable="false"
					onclick="info.innerHTML=''" />
				<br/><br>
				
				<input type="submit" value="�ϴ�" />
			</form>
			<div id="info">
				${message}
			</div>		
			
		</div>
		
	
	</body>
</html>