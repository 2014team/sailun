
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
	'admin/CENTER/BANNER/DELETE': {url: '/admin/center/banner/delete', isUsed: true, desc: '首页广告列删除'},
	'admin/CENTER/BANNER/UPDATE': {url: '/admin/center/banner/update', isUsed: true, desc: '联系信息更新'},
	'admin/CENTER/BANNER/EDIT': {url: '/admin/center/banner/edit', isUsed: true, desc: '首页广告列编辑'},
	'admin/CENTER/BANNER/SAVE': {url: '/admin/center/banner/save', isUsed: true, desc: '首页广告列'},
	'admin/CENTER/BANNER/BATCH/DELETE': {url: '/admin/center/banner/batch/delete', isUsed: true, desc: '首页广告列批量删除'},
	'admin/CENTER/BANNER/GET': {url: '/admin/center/banner/get', isUsed: true, desc: '查找单个首页广告列'},
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
