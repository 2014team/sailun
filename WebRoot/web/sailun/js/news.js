


function search(){
	$.ajax({
		url : "/news/type",
		type : "get",
		cache:false,
		dataType : "text",
		success : function(data) {
			debugger
			$("#news_list").html(data);
		},
		error : function(err) {
		}
	});
	
}