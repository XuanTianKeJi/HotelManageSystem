<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload= function(){
	var index = parent.layer.index; //获取当前弹层的索引号
	parent.layer.close(index);
	 window.parent.location.reload();//刷新父页面
}
</script>
</html>