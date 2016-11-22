package it304.sys;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import it304.sys.init.WeChatMenuInit;
import it304.sys.read.WeiXinProperties;
import it304.task.wechat.GetToken;

/**
 * spring在创建容器完成之后自动执行的类，此类会监控ContextRefreshedEvent事件（容器初始化完成事件）
 * 
 * @author DK
 *
 */
public class InitClass implements ApplicationListener<ContextRefreshedEvent> {
	@Resource
	private GetToken getToken;
	@Resource
	private WeChatMenuInit weChatMenuInit;

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		WeiXinProperties.read();
		getToken.getAccess_token();
		try {
			weChatMenuInit.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
