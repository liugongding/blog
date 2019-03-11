		layui.use([ 'jquery', 'laypage', 'layer' ], function() {
			var $ = layui.jquery, laypage = layui.laypage, layer = layui.layer;
			 
			$('#item-btn').click(function() {
				if(($("#message").val()=='')||($("#name").val()=='')){
					 layer.msg("哪里没填自己心里点数吗！");
	             } else {
					$.ajax({
					type : "post",
					url : "/blog/test/addmessage",
					data : {
						"name"	: $("#name").val(),
						"words" : $("#message").val(),
					},
					success : function(data) {
						 if(data.stateCode == "1") {
							 location.reload();
                         }  
						 if(data.stateCode == "0")   {
                        	 layer.msg("提交失败");
                         }
					},
					error : function() {
						layer.msg("404");
						}
					});
	          	 }
			});
			
			$(document).ready(function(){
				window.page={pageCode:1,totalPage:0,totalCount:0,pageSize:2};
				listMessage();
				laypage.render({
					  elem: 'page',
					  limit:window.page.pageSize,
					  count: window.page.totalCount, //数据总数，从服务端得到
						jump: function(obj, first){
					    //首次不执行
					    if(!first){
					    	 window.page.pageCode=obj.curr;
					    	 listMessage();
					    }
					  }
					});
				function listMessage(){
				$.ajax({
					url:"/blog/test/listMessage",
					type:"post",
					data:page,
					dataType:"json",
					async:false,
					success:function(data){
						var result = data.message;
						var html = "";
						window.page.totalCount = result.totalCount;
						for (var i = 0; i < result.beanList.length; i++) {
							var temp = result.beanList[i];
							var name = temp.name;
							var words = temp.words;
							html +='<div class="info-item">'
									+'<div class="info-text">'
									+'<p class="title count">'
									+'<span class="name">'+name+'</span> '
									+'<span class="info-img like"><i class="layui-icon layui-icon-praise"></i>5.8万</span>'
									+'</p>'
									+'<p class="info-intr">'+words+'</p>'
									+'</div>'
									+'</div>'
						}
						$(".info-box").html(html);
					},
					error:function(res){
						alert("hello");
					}
				});
				}
			});
		});