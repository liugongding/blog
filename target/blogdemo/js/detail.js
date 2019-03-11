layui.use([ 'jquery', 'laypage', 'layer' ], function() {
		var $ = layui.jquery, laypage = layui.laypage, layer = layui.layer;
		
	$(document).ready(function(){
		function GetQueryString(name)
		{
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		     var r = window.location.search.substr(1).match(reg);
		     if(r!=null)return  unescape(r[2]); return null;
		}
		Id = GetQueryString("id");
		window.page={pageCode:1,totalPage:0,totalCount:0,pageSize:2,id:Id};
		listComment();
		laypage.render({
			  elem: 'page',
			  limit:window.page.pageSize,
			  count: window.page.totalCount, //数据总数，从服务端得到
				jump: function(obj, first){
			    //首次不执行
			    if(!first){
			    	 window.page.pageCode=obj.curr;
			    	 listComment();
			    }
			  }
			});
		function listComment(){
		
		$.ajax({
			url:"/blog/comment/listComment",
			type:"post",
			data:page,
			dataType:"json",
			async:false,
			success:function(data) {
				var result = data.comment;
				var html = "";
				window.page.totalCount = result.totalCount;
				for (var i = 0; i < result.beanList.length; i++) {
					var temp = result.beanList[i];
					var name = temp.name;
					var words = temp.words
					html += '<div class="info-item">'
						+'<div class="info-text">'
						+'<p class="title count">'
						+'<span class="name">'+name+'</span>'
						+'<span class="info-img like"><i class="layui-icon layui-icon-praise"></i>5.8万</span>'
						+'</p>'
						+'<p>'+words+'</p>'
						+'</div>'
						+'</div>'
				}
				$(".info-item").html(html);
			}
		});
		}
		$.ajax({
			url:"/blog/Articles/getBlogById",
			type:"post",
			dataType:"json",
			data:{"id":Id,},
			success:function(data) {
				var result = data.blog;
				var html1="";
				var html2="";
				var id = result.id;
				var title = result.title;
				var time = result.time;
				var name = result.name;
				var articles = result.articles;
				html1 +='<div class="item">'
						+'<div class="item-box  layer-photos-demo1 layer-photos-demo">'
						+'<h3>'+title+'</h3>'
						+'<h5>发布于：<span>'+time+'</span></h5>'
						+'<h5>作者：<span>'+name+'</span></h5>'
						+'<p>'+articles+'</p>'
						+'<div class="count layui-clear">'
						+'<span class="pull-left">阅读 <em>100000+</em></span>'
						+'<span class="pull-right like"><i class="layui-icon layui-icon-praise"></i><em>999</em></span>'
						+'</div>'
						+'</div>'
						+'</div>'
				html2 += '<div class="comt layui-clear">'	
						+'<a href="javascript:;" class="pull-left">评论</a>'
						+'<a href="comment.html?id='+id+'" class="pull-right">写评论</a>'
						+'</div>'
				$("#blog").html(html1);
				$("#demo").html(html2);
			}
		});
	});
	});