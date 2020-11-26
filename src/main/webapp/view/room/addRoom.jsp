<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>表单元素</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../layuiadmin/style/admin.css" media="all">
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md6">
        <div class="layui-card">
          <div class="layui-card-header">添加房间</div>
          <div class="layui-card-body">
            <form class="layui-form" action="${pageContext.request.contextPath}/room/addRoom.do" lay-filter="component-form-element" method="post">
            
                <div class="layui-col-lg6">
                  <label class="layui-form-label">房间编号：</label>
                  <div class="layui-input-block">
                    <input type="text" name="roomId" lay-verify="required" placeholder="房间编号" autocomplete="off" class="layui-input" pattern="^[O,T,S,F,M][0-9][0-9][0-9]">
                  </div>
                </div>
                <input type="text" name="roomStatus" value="未入住" style="display:none" >
             
              <div class="layui-form-item">
                <label class="layui-form-label">房间类型</label>
                <div class="layui-input-block">
                  <input type="radio" name="roomType" value="单人间" title="单人间">
                  <input type="radio" name="roomType" value="双人间" title="双人间">
                  <input type="radio" name="roomType" value="三人间" title="三人间">
                  <input type="radio" name="roomType" value="多人间" title="多人间">
                  <input type="radio" name="roomType" value="其他" title="其他">
                </div>
              </div>
              <div class="layui-col-lg6">
                  <label class="layui-form-label">房间价格：</label>
                  <div class="layui-input-block">
                    <input type="number" name="roomPrice" lay-verify="required" placeholder="房间价格" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <br><br><br>
                <div class="layui-input-block">
                  <button class="layui-btn" lay-submit lay-filter="component-form-element">立即提交</button>
                  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  
  <script src="../layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,form = layui.form;
    
    form.render(null, 'component-form-element');
    element.render('breadcrumb', 'breadcrumb');
    form.on('submit(component-form-element)', function(data){
    
        return true;
      });
  });
  </script>
</body>
</html>