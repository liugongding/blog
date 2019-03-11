layui.use(['jquery','laypage','layer'],function(){
			var $ = layui.jquery,
			laypage = layui.laypage,
			layer = layui.layer;
			$("#btn").click(function() {
			if(($("#textarea").val()=='')||($("#name").val()=='')){
						 layer.msg("哪里没填自己心里点数吗！");
		        } else {
		        function GetQueryString(name)
				{
					var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
					var r = window.location.search.substr(1).match(reg);
					if(r!=null)return  unescape(r[2]); 
					return null;
				}
					Id = GetQueryString("id");
				$.ajax({
					url : "/blog/comment/addComment",
					type : "post",
					data : {
						"articleId":Id,
						"name" : $("#name").val(),
						"words" : $("#textarea").val(),
					},
					success : function(data) {
						if (data == "success") {
							window.location.href="details.html?id="+Id;
						}
						if (data == "falure") {
							layer.msg("评论失败");		
						}
					},
					error : function() {
						layer.msg("404");
						}
				}) 
		             }
	      	})
			
			});