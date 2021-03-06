<html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<link rel="stylesheet" href="<%=basePath %>/css/modules/statistics/statistics.css"/>
<link rel="stylesheet" href="<%=basePath %>/css/sweetalert2.min.css"/>
 <!-- 统计展示数据 不能删除   不能注释 -->
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/modules/statistics/statisticsQuery.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/sweetalert2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.0.js"></script>

<body>
<div class="container" style="margin-top: 20px">
		<table class="table table-bordered" id="GridView">
			<thead>
				<tr>
					<td>类型</td>
					<td>标识</td>
					<td>目前ES数据量</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">物流</td>
					<td class="col-md-2">logistics</td>
					<td class="col-md-2" id="logistics"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">账号</td>
					<td class="col-md-2">account</td>
					<td class="col-md-2" id="account"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">邮箱</td>
					<td class="col-md-2">mailbox</td>
					<td class="col-md-2" id="mailbox"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">车类</td>
					<td class="col-md-2">carOwner</td>
					<td class="col-md-2" id="car"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">房产</td>
					<td class="col-md-2">house</td>
					<td class="col-md-2" id="house"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">工商</td>
					<td class="col-md-2">business</td>
					<td class="col-md-2" id="business"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">学生</td>
					<td class="col-md-2">student</td>
					<td class="col-md-2" id="student"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">电信</td>
					<td class="col-md-2">telecom</td>
					<td class="col-md-2" id="telecom"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">互联网</td>
					<td class="col-md-2">internet</td>
					<td class="col-md-2" id="Internet"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">通讯录</td>
					<td class="col-md-2">contact</td>
					<td class="col-md-2" id="contact"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">酒店</td>
					<td class="col-md-2">hotel</td>
					<td class="col-md-2" id="hotel"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">医院</td>
					<td class="col-md-2">hospital</td>
					<td class="col-md-2" id="hospital"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">金融</td>
					<td class="col-md-2">finance</td>
					<td class="col-md-2" id="finance"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">机票</td>
					<td class="col-md-2">airline</td>
					<td class="col-md-2" id="airplane"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">简历</td>
					<td class="col-md-2">resume</td>
					<td class="col-md-2" id="resume"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">网吧</td>
					<td class="col-md-2">cybercafe</td>
					<td class="col-md-2" id="cybercafe"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">社保</td>
					<td class="col-md-2">socialSecurity</td>
					<td class="col-md-2" id="socialSecurity"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">QQ</td>
					<td class="col-md-2">QQ</td>
					<td class="col-md-2" id="qqdata"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">QQ群</td>
					<td class="col-md-2">QQQun</td>
					<td class="col-md-2" id="qqqundata"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">QQ群关系</td>
					<td class="col-md-2">QQQunData</td>
					<td class="col-md-2" id="qqqunrelation"></td>
				</tr>
				<tr>
					<td class="col-md-2 one-td" data-toggle="modal" data-target="#myModal">资格考试</td>
					<td class="col-md-2">qualiFication</td>
					<td class="col-md-2" id="Qualification"></td>
				</tr>
				<tr>
					<td class="col-md-2">总计ES数据量</td>
					<td class="col-md-2"></td>
					<td class="col-md-2" id="heji"></td>
				</tr>
			</tbody>
		</table>
	</div>
	
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel" style="font-weight: bold;">标识 详情</h4>
      </div>
      <div class="modal-body">
      	<button class="btn btn-default" data-dismiss="modal" style="margin-left: 402px;width: 89px;color: red;margin-bottom: 10px;" data-toggle="modal" data-target="#save" id="saves">添加</button>
      	<table class="table table-bordered" id="tableData">
      		<tbody id="results">

			</tbody>
		</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!--  添加     -->
<div class="modal fade" id="save" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel" style="font-weight: bold;">添加</h4>
      </div>
      <div class="modal-body">
      	<div style="text-align: center;margin: 10px;"><label>集群：</label><input id='indexA'/></div>
		<div style="text-align: center;margin: 10px;"><label>库群：</label><input id='typeA'/></div>
		<div style="text-align: center;margin: 10px;"><label>字段：</label><input id='attribute_enA'></div>
		<div style="text-align: center;margin: 10px;"><label>内容：</label><input id='attribute_chA'></div>
		<div style="text-align: center;margin: 10px;">
			<button class="btn btn-default" data-dismiss="modal" style="width: 80px;float: right;margin-top: -25px;" id="addType">保存</button>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- 修改  -->
<div class="modal fade" id="updata" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel" style="font-weight: bold;">修改</h4>
      </div>
      <div class="modal-body">
		<div style="text-align: center;margin: 10px;"><label>集群：</label><input id='indexB'/></div>
		<div style="text-align: center;margin: 10px;"><label>库群：</label><input id='typeB'></div>
		<div style="text-align: center;margin: 10px;"><label>字段：</label><input id='attribute_enB'></div>
		<div style="text-align: center;margin: 10px;"><label>内容：</label><input id='attribute_chB'></div>
		<div style="text-align: center;margin: 10px;">
			<button class="btn btn-default" data-dismiss="modal" style="width: 80px;float: right;margin-top: -25px;" id="updataType">修改</button>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- 点击搜索后的背景显示 -->
<div id="background" class="all_backgroundcolor" align="center">
		<img class="background_img"  src="<%=basePath %>/img/backgroundcenter.gif">
	</div>
</body>
</html>
