
var admin_url_map = {
	'admin/LOGIN/SUBMIT': {url: '/admin/login/submit', isUsed: true, desc: '首页'},
	'admin/INDEX': {url: '/admin/index', isUsed: true, desc: '跳转登录'},
	
	//用户
	'admin/CENTER/USER/LIST': {url: '/admin/center/user/list', isUsed: true, desc: '管理员列表'},
	'admin/CENTER/USER/VALIDFLAG': {url: '/admin/center/user/validFlag', isUsed: true, desc: '更新状态'},
	'admin/CENTER/USER/DELETE': {url: '/admin/center/user/delete', isUsed: true, desc: '删除用户'},
	'admin/CENTER/USER/UPDATE': {url: '/admin/center/user/update', isUsed: true, desc: '修改用户'},
	'admin/CENTER/USER/EDIT': {url: '/admin/center/user/edit', isUsed: true, desc: '编辑用户'},
	'admin/CENTER/USER/SAVE': {url: '/admin/center/user/save', isUsed: true, desc: '保存用户'},
	'admin/CENTER/USER/BATCH/DELETE': {url: '/admin/center/user/batch/delete', isUsed: true, desc: '用户批量删除'},
	'admin/CENTER/USER/GET': {url: '/admin/center/user/get', isUsed: true, desc: '查找单个用户'},
	
	//角色
	'admin/CENTER/ROLE/GET': {url: '/admin/center/role/get', isUsed: true, desc: '角色查找'},
	'admin/CENTER/ROLE/SAVE': {url: '/admin/center/role/save', isUsed: true, desc: '角色保存'},
	'admin/CENTER/ROLE/DELETE': {url: '/admin/center/role/delete', isUsed: true, desc: '角色删除'},
	'admin/CENTER/ROLE/UPDATE': {url: '/admin/center/role/update', isUsed: true, desc: '角色修改'},
	'admin/CENTER/ROLE/EDIT': {url: '/admin/center/role/edit', isUsed: true, desc: '角色编辑'},
	'admin/CENTER/ROLE/LIST': {url: '/admin/center/role/list', isUsed: true, desc: '角色列表'},
	'admin/CENTER/ROLE/BATCH/DELETE': {url: '/admin/center/role/batch/delete', isUsed: true, desc: '角色批量删除'},
	'admin/CENTER/ROLE/VALIDFLAG': {url: '/admin/center/role/validFlag', isUsed: true, desc: '角色状态修改'},
	'admin/CENTER/ROLE/RIGHT': {url: '/admin/center/role/right', isUsed: true, desc: '角色分配权限'},
	'admin/CENTER/ROLE/RIGHT/SAVE': {url: '/admin/center/role/right/save', isUsed: true, desc: '角色分配权限保存'},
	
	//菜单
	'admin/CENTER/MENU/GET': {url: '/admin/center/menu/get', isUsed: true, desc: '菜单查找'},
	'admin/CENTER/MENU/SAVE': {url: '/admin/center/menu/save', isUsed: true, desc: '菜单保存'},
	'admin/CENTER/MENU/DELETE': {url: '/admin/center/menu/delete', isUsed: true, desc: '菜单删除'},
	'admin/CENTER/MENU/UPDATE': {url: '/admin/center/menu/update', isUsed: true, desc: '菜单修改'},
	'admin/CENTER/MENU/EDIT': {url: '/admin/center/menu/edit', isUsed: true, desc: '菜单编辑'},
	'admin/CENTER/MENU/LIST': {url: '/admin/center/menu/list', isUsed: true, desc: '菜单列表'},
	'admin/CENTER/MENU/BATCH/DELETE': {url: '/admin/center/menu/batch/delete', isUsed: true, desc: '菜单批量删除'},
	'admin/CENTER/MENU/VALIDFLAG': {url: '/admin/center/menu/validFlag', isUsed: true, desc: '菜单状态修改'},
	
	//日志
	'admin/CENTER/LOG/DETAIL': {url: '/admin/center/log/detail', isUsed: true, desc: '日志详情'},
	'admin/CENTER/LOG/LIST': {url: '/admin/center/log/list', isUsed: true, desc: '日志列表'},
	'admin/CENTER/LOG/BATCH/DELETE': {url: '/admin/center/log/batch/delete', isUsed: true, desc: '日志批量删除'},
	
	
	// 联系信息
	'admin/CENTER/CONTACT/LIST': {url: '/admin/center/contact/list', isUsed: true, desc: '联系信息列表'},
	'admin/CENTER/CONTACT/DELETE': {url: '/admin/center/contact/delete', isUsed: true, desc: '联系信息删除'},
	'admin/CENTER/CONTACT/UPDATE': {url: '/admin/center/contact/update', isUsed: true, desc: '联系信息更新'},
	'admin/CENTER/CONTACT/EDIT': {url: '/admin/center/contact/edit', isUsed: true, desc: '编辑联系信息'},
	'admin/CENTER/CONTACT/DETAIL': {url: '/admin/center/contact/detail', isUsed: true, desc: '详情联系信息'},
	'admin/CENTER/CONTACT/SAVE': {url: '/admin/center/contact/save', isUsed: true, desc: '保存联系信息'},
	'admin/CENTER/CONTACT/BATCH/DELETE': {url: '/admin/center/contact/batch/delete', isUsed: true, desc: '联系信息批量删除'},
	'admin/CENTER/CONTACT/GET': {url: '/admin/center/contact/get', isUsed: true, desc: '查找单个联系信息'},
	'admin/CENTER/CONTACT/EXPORT': {url: '/admin/center/contact/export', isUsed: true, desc: '导出联系信息'},
	
	//首页广告
	'admin/CENTER/BANNER/LIST': {url: '/admin/center/banner/list', isUsed: true, desc: '首页广告列表'},
	'admin/CENTER/BANNER/DELETE': {url: '/admin/center/banner/delete', isUsed: true, desc: '首页广告删除'},
	'admin/CENTER/BANNER/UPDATE': {url: '/admin/center/banner/update', isUsed: true, desc: '联系信息更新'},
	'admin/CENTER/BANNER/EDIT': {url: '/admin/center/banner/edit', isUsed: true, desc: '首页广告编辑'},
	'admin/CENTER/BANNER/SAVE': {url: '/admin/center/banner/save', isUsed: true, desc: '首页广告'},
	'admin/CENTER/BANNER/BATCH/DELETE': {url: '/admin/center/banner/batch/delete', isUsed: true, desc: '首页广告批量删除'},
	'admin/CENTER/BANNER/GET': {url: '/admin/center/banner/get', isUsed: true, desc: '查找单个首页广告'},
	
	//关于我们
	'admin/CENTER/ABOUTUS/LIST': {url: '/admin/center/aboutus/list', isUsed: true, desc: '关于我们列表'},
	'admin/CENTER/ABOUTUS/DELETE': {url: '/admin/center/aboutus/delete', isUsed: true, desc: '关于我们删除'},
	'admin/CENTER/ABOUTUS/UPDATE': {url: '/admin/center/aboutus/update', isUsed: true, desc: '关于我们更新'},
	'admin/CENTER/ABOUTUS/EDIT': {url: '/admin/center/aboutus/edit', isUsed: true, desc: '关于我们编辑'},
	'admin/CENTER/ABOUTUS/SAVE': {url: '/admin/center/aboutus/save', isUsed: true, desc: '关于我们保存'},
	'admin/CENTER/ABOUTUS/BATCH/DELETE': {url: '/admin/center/aboutus/batch/delete', isUsed: true, desc: '关于我们批量删除'},
	'admin/CENTER/ABOUTUS/GET': {url: '/admin/center/aboutus/get', isUsed: true, desc: '查找单个关于我们'},
	
	//产品展示
	'admin/CENTER/PRODUCT/LIST': {url: '/admin/center/product/list', isUsed: true, desc: '产品展示列表'},
	'admin/CENTER/PRODUCT/DELETE': {url: '/admin/center/product/delete', isUsed: true, desc: '产品展示删除'},
	'admin/CENTER/PRODUCT/UPDATE': {url: '/admin/center/product/update', isUsed: true, desc: '产品展示更新'},
	'admin/CENTER/PRODUCT/EDIT': {url: '/admin/center/product/edit', isUsed: true, desc: '产品展示编辑'},
	'admin/CENTER/PRODUCT/SAVE': {url: '/admin/center/product/save', isUsed: true, desc: '产品展示保存'},
	'admin/CENTER/PRODUCT/BATCH/DELETE': {url: '/admin/center/product/batch/delete', isUsed: true, desc: '产品展示批量删除'},
	'admin/CENTER/PRODUCT/GET': {url: '/admin/center/product/get', isUsed: true, desc: '查找单个产品展示'},
	
	//产品分类
	'admin/CENTER/PRODUCTTYPE/LIST': {url: '/admin/center/productType/list', isUsed: true, desc: '产品分类列表'},
	'admin/CENTER/PRODUCTTYPE/DELETE': {url: '/admin/center/productType/delete', isUsed: true, desc: '产品分类删除'},
	'admin/CENTER/PRODUCTTYPE/UPDATE': {url: '/admin/center/productType/update', isUsed: true, desc: '产品分类更新'},
	'admin/CENTER/PRODUCTTYPE/EDIT': {url: '/admin/center/productType/edit', isUsed: true, desc: '产品分类编辑'},
	'admin/CENTER/PRODUCTTYPE/SAVE': {url: '/admin/center/productType/save', isUsed: true, desc: '产品分类保存'},
	'admin/CENTER/PRODUCTTYPE/BATCH/DELETE': {url: '/admin/productType/product/batch/delete', isUsed: true, desc: '产品分类批量删除'},
	'admin/CENTER/PRODUCTTYPE/GET': {url: '/admin/center/productType/get', isUsed: true, desc: '查找单个产品分类'},
	
	//新闻分类
	'admin/CENTER/NEWSTYPE/LIST': {url: '/admin/center/newsType/list', isUsed: true, desc: '新闻分类列表'},
	'admin/CENTER/NEWSTYPE/DELETE': {url: '/admin/center/newsType/delete', isUsed: true, desc: '新闻分类删除'},
	'admin/CENTER/NEWSTYPE/UPDATE': {url: '/admin/center/newsType/update', isUsed: true, desc: '新闻分类更新'},
	'admin/CENTER/NEWSTYPE/EDIT': {url: '/admin/center/newsType/edit', isUsed: true, desc: '新闻分类编辑'},
	'admin/CENTER/NEWSTYPE/SAVE': {url: '/admin/center/newsType/save', isUsed: true, desc: '新闻分类保存'},
	'admin/CENTER/NEWSTYPE/BATCH/DELETE': {url: '/admin/center/newsType/batch/delete', isUsed: true, desc: '新闻分类批量删除'},
	'admin/CENTER/NEWSTYPE/GET': {url: '/admin/center/newsType/get', isUsed: true, desc: '查找单个新闻分类'},
	//资讯发布
	'admin/CENTER/NEWS/LIST': {url: '/admin/center/news/list', isUsed: true, desc: '资讯发布列表'},
	'admin/CENTER/NEWS/DELETE': {url: '/admin/center/news/delete', isUsed: true, desc: '资讯发布删除'},
	'admin/CENTER/NEWS/UPDATE': {url: '/admin/center/news/update', isUsed: true, desc: '资讯发布更新'},
	'admin/CENTER/NEWS/EDIT': {url: '/admin/center/news/edit', isUsed: true, desc: '资讯发布编辑'},
	'admin/CENTER/NEWS/SAVE': {url: '/admin/center/news/save', isUsed: true, desc: '资讯发布保存'},
	'admin/CENTER/NEWS/BATCH/DELETE': {url: '/admin/center/news/batch/delete', isUsed: true, desc: '资讯发布批量删除'},
	'admin/CENTER/NEWS/GET': {url: '/admin/center/news/get', isUsed: true, desc: '查找单个资讯发布'},
	
	//车手介绍
	'admin/CENTER/DRIVER/LIST': {url: '/admin/center/driver/list', isUsed: true, desc: '车手介绍列表'},
	'admin/CENTER/DRIVER/DELETE': {url: '/admin/center/driver/delete', isUsed: true, desc: '车手介绍删除'},
	'admin/CENTER/DRIVER/UPDATE': {url: '/admin/center/driver/update', isUsed: true, desc: '车手介绍更新'},
	'admin/CENTER/DRIVER/EDIT': {url: '/admin/center/driver/edit', isUsed: true, desc: '车手介绍编辑'},
	'admin/CENTER/DRIVER/SAVE': {url: '/admin/center/driver/save', isUsed: true, desc: '车手介绍保存'},
	'admin/CENTER/DRIVER/BATCH/DELETE': {url: '/admin/center/driver/batch/delete', isUsed: true, desc: '车手介绍批量删除'},
	'admin/CENTER/DRIVER/GET': {url: '/admin/center/driver/get', isUsed: true, desc: '查找单个车手介绍'},
	
	//页面创建
	'admin/CENTER/PAGECREATE/LIST': {url: '/admin/center/pageCreate/list', isUsed: true, desc: '页面创建列表'},
	'admin/CENTER/PAGECREATE/DELETE': {url: '/admin/center/pageCreate/delete', isUsed: true, desc: '页面创建删除'},
	'admin/CENTER/PAGECREATE/UPDATE': {url: '/admin/center/pageCreate/update', isUsed: true, desc: '页面创建更新'},
	'admin/CENTER/PAGECREATE/EDIT': {url: '/admin/center/pageCreate/edit', isUsed: true, desc: '页面创建编辑'},
	'admin/CENTER/PAGECREATE/SAVE': {url: '/admin/center/pageCreate/save', isUsed: true, desc: '页面创建保存'},
	'admin/CENTER/PAGECREATE/BATCH/DELETE': {url: '/admin/center/pageCreate/batch/delete', isUsed: true, desc: '页面创建批量删除'},
	'admin/CENTER/PAGECREATE/GET': {url: '/admin/center/pageCreate/get', isUsed: true, desc: '查找单个页面创建'},
	
	//页面配置
	'admin/CENTER/PAGECONFIG/LIST': {url: '/admin/center/pageConfig/list', isUsed: true, desc: '页面配置列表'},
	'admin/CENTER/PAGECONFIG/DELETE': {url: '/admin/center/pageConfig/delete', isUsed: true, desc: '页面配置删除'},
	'admin/CENTER/PAGECONFIG/UPDATE': {url: '/admin/center/pageConfig/update', isUsed: true, desc: '页面配置更新'},
	'admin/CENTER/PAGECONFIG/EDIT': {url: '/admin/center/pageConfig/edit', isUsed: true, desc: '页面配置编辑'},
	'admin/CENTER/PAGECONFIG/SAVE': {url: '/admin/center/pageConfig/save', isUsed: true, desc: '页面配置保存'},
	'admin/CENTER/PAGECONFIG/BATCH/DELETE': {url: '/admin/center/pageConfig/batch/delete', isUsed: true, desc: '页面配置批量删除'},
	'admin/CENTER/PAGECONFIG/GET': {url: '/admin/center/pageConfig/get', isUsed: true, desc: '查找单个页面配置'},
	'admin/CENTER/PAGECONFIG/CHECKUNIQUE': {url: '/admin/center/pageConfig/checkUnique', isUsed: true, desc: '查找单个页面配置'},
}

var web_url_map = {

}



function getAminUrl(key) {
	if(admin_url_map[key] && admin_url_map[key].isUsed == true){
		return admin_url_map[key].url;
	}else{
		return '';
	}
}

function getWebUrl(key) {
	if(web_url_map[key] && web_url_map[key].isUsed == true){
		return web_url_map[key].url;
	}else{
		return '';
	}
}
