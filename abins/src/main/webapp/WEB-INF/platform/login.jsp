<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@include file="/resource/common/admin/header.jsp" %>
		<style>
			body{background-image:url(${ctx}/resource/theme/ace/assets/images/login-background.jpg)}
		</style>
	</head>
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">Ace</span>
									<span class="white">abins</span>
								</h1>
								<h4 class="blue">&copy; abins company</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible no-border" style="margin-top: 20%;">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<c:choose>
													<c:when test="${!empty fail}">
														<i class="icon-warning-sign red"></i>${fail }!
													</c:when>
													<c:otherwise>
														<i class="icon-coffee green"></i>请输入您的登录信息
													</c:otherwise>
												</c:choose>
											</h4>
											<div class="space-6"></div>

											<form id="loginForm" action="${ctx }/platform/main/login" method="post">
												<fieldset>
													<input type="hidden" value="${tokenId }" name="tokenId"/>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="账号或邮箱" name="login"/>
															<i class="icon-user"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" name="password"/>
															<i class="icon-lock"></i>
														</span>
													</label>
													<div class="space"></div>
													<div class="clearfix">
														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
													</div>
													<div class="space-4"></div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
	<script type="text/javascript">
		function show_box(id) {
		 jQuery('.widget-box.visible').removeClass('visible');
		 jQuery('#'+id).addClass('visible');
		}
	</script>
<script type="text/javascript">
//var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
//document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fe9e1d61340ff3d9495a8cca04ebdb49d' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>
