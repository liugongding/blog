layui.use(['jquery','laypage','layer'],function(){
		var $ = layui.jquery,
		laypage = layui.laypage,
		layer = layui.layer;
		
		$(document).ready(function(){
			window.page={pageCode:1,totalPage:0,totalCount:0,pageSize:2};
			findByPage();
			laypage.render({
				  elem: 'page',
				  limit:window.page.pageSize,
				  count: window.page.totalCount, //数据总数，从服务端得到
					jump: function(obj, first){
				    //首次不执行
				    if(!first){
				    	 window.page.pageCode=obj.curr;
				    	 findByPage();
				    }
				  }
				});
		
			function findByPage(){
			$.ajax({
				url:"/blog/Articles/listArticles",
				type:"post",
				data:page,
				async:false,
				dataType:"json",
				success:function(data) {
					var result = data.blog;
					var html="";
					//将page重新赋值。你将返回的总行数赋值到page里面
					window.page.totalCount = result.totalCount;
					for (var i = 0; i < result.beanList.length; i++) {
						var temp = result.beanList[i];
						var id = temp.id;
						var title = temp.title;
						var time = temp.time;
						var name = temp.name;
						var articles = temp.articles.substr(0,86);
						html += '<div class="item" style="margin:10px;">'
									+'<div class="item-box  layer-photos-demo1 layer-photos-demo">'
										+'<h3>'+title+'</h3>'
											+'<h5>发布于：<span>'+time+'</span></h5>'
											+'<h5>作者：<span>'+name+'</span></h5>'
											+'<p>'+articles+'</p>'
									+'</div>'	
									+'<div class="comment count">'
										+'<a href="details.html?id='+id+'">阅读</a>'
										+'<a href="javascript:;" class="like">点赞</a>'
									+'</div>'
								+'</div>'
						}
						$(".items").html(html)
					},
					error:function(res){
						alert("提交数据格式错误")
					}
				});
				}
			});
		});
		