<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>自定义分页 - 数据表格</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="../layuiadmin/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="../layuiadmin/style/admin.css" media="all">
<script src="../layuiadmin/layui/layui.js"></script>
<script src="../static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
</head>
<body>
	
	<div class="layui-card layadmin-header">
		<div class="layui-breadcrumb" lay-filter="breadcrumb">
			<a lay-href="">主页</a> <a><cite>组件</cite></a> <a><cite>数据表格</cite></a>
			<a><cite>自定义分页</cite></a>
		</div>
	</div>

	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
	<button class="layui-btn layui-btn-radius layui-btn-normal" id="addRoomButton">添加房间</button>
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">房间列表</div>
					<div class="layui-card-body">
						<table id="roomList" lay-data="{id:'roomList'}" lay-filter="roomList"></table>
					</div>
				</div>
			</div>
		</div>
	</div>

<script type="text/html" id="barDemo">
 
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
layui.use('table', function(){
	var table = layui.table;
	 
	//执行渲染
var tableIns =	table.render({
		elem: '#roomList'
		      ,url: '${pageContext.request.contextPath}/room/roomListPageOn.do'
		      ,method:'post'
		      ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
		    	 elem:'roomList'
		        ,layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
		        ,curr: 1 //设定初始在第 5 页
		        ,groups: 1 //只显示 1 个连续页码
		        ,first: false //不显示首页
		        ,last: false //不显示尾页
		        ,limits:[5,10,15,20]
		      }
		      ,cols: [[
		        {field:'roomId', title: '房间', sort: true}
		        ,{field:'roomType',  title: '房间类型'}
		        ,{field:'roomStatus', edit:'text',title: '房间状态'}
		        ,{field:'roomPrice', edit:'text', title: '房间价格'}
		        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
		      ]]
	});
	
	 table.on('tool(roomList)', function(obj){
		    var data = obj.data;
		    console.log(obj);
		    if(obj.event === 'del'){
		      layer.confirm('真的删除行么', function(index){
		        obj.del();
		        layer.close(index);
		        $.ajax({//异步删除
		        		"url":"${pageContext.request.contextPath}/room/delRoom.do",
		    			"data":{"roomId":data.roomId},
		    			"type":"post",
		    			"dataType":"json",
		    			"error":function(obj) {
		    				tableIns.reload({//数据表格重载
		    					  where: { //设定异步数据接口的额外参数，任意设
		    					  }
		    					  ,page: {
		    					    curr: 1 //重新从第 1 页开始
		    					  }
		    					});
		    			},
		        } );
		      });
		    } 
		  });
	 
	 table.on('edit(roomList)', function(obj){
		    var value = obj.value //得到修改后的值
		    ,data = obj.data //得到所在行所有键值
		    ,field = obj.field; //得到字段
		    $.ajax({//异步修改
        		"url":"${pageContext.request.contextPath}/room/updateRoom.do",
    			"data":{
    				"filed":field
    				,"value":value
    				,"roomId":data.roomId
    				},
    			"type":"post",
    			"dataType":"json",
    			"error":function(obj) {
    				layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
    			},
        } );
		  });
	 
});

$(document).ready(function(){
	 
	$("#addRoomButton").click(function(){
		layer.open({
			  title: '新增房间'
			  ,type:2
			  ,area: ['800px', '600px']
			  ,content: ['${pageContext.request.contextPath}/room/addRoom','no']
			
			});   
	});
});

 </script>
</body>
</html>