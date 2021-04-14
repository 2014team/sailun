package com.sailun.common.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sailun.util.LogUtil;
import com.sailun.util.PropertiesUtil;

@Component
public class ConfigListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (null == event.getApplicationContext().getParent()) {
			LogUtil.logInfo("系统开始初始化配置文件");
			PropertiesUtil.init("/config/common.properties");
		}
	}

}