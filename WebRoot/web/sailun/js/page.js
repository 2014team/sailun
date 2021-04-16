var page_url="";
var limit="";
function initPageUrl(page_url,limit){
	this.page_url = page_url;
	this.limit = limit;
}
function searchByPage(page){
	$.ajax({
		url : this.page_url,
		type : "post",
		data:{"page":page,"limit":this.limit},
		cache:false,
		dataType : "text",
		success : function(data) {
			$("#list_div").html(data);
		},
		error : function(err) {
			console.log(err)
		}
	});
	
}