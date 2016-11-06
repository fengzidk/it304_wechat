package it304.bo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it304.parametermodel.WeChat;
import it304.service.passivereply.PassiveReplyWeChatControl;
import it304.util.wechat.AnalysisWeChat;
import it304.util.wechat.SignUtil;

/**
 * 微信消息的入口
 * 
 * @author DK
 *
 */
@Controller
@RequestMapping("/weixin")
public class WeiXinEntrance {
	@Resource
	private PassiveReplyWeChatControl passiveReplyWeChatControl;

	/**
	 * 用来绑定微信的url时调用的借口
	 * 
	 * @param wc
	 * @return
	 */
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	@ResponseBody
	public String testInterface(WeChat wc) {
		long start = System.currentTimeMillis();
		System.out.println("/api");
		String signature = wc.getSignature(); // 微信加密签名
		String timestamp = wc.getTimestamp(); // 时间戳
		String nonce = wc.getNonce();// 随机数
		String echostr = wc.getEchostr();// 随机字符串
		System.out.println(wc.toString());
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			System.out.println(echostr);
			System.out.println(((long) System.currentTimeMillis() - start) + "ms");
			return echostr;
		} else {
			System.out.println("不是微信服务器发来的请求,请小心!");
			return null;
		}
	}

	@RequestMapping(value = "/api", method = RequestMethod.POST)
	public void receiveTheMessageInterface(WeChat wc, HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// 不是微信发来的信息 直接返回""字符串
		String returnStr = "";
		// 如果是微信发来的信息
		if (SignUtil.checkSignature(wc.getSignature(), wc.getTimestamp(), wc.getNonce())) {
			// 解析生成map
			Map<String, String> whChatMessage = AnalysisWeChat.analysisWeChatRequestToMap(request);
			returnStr = passiveReplyWeChatControl.passiveReplyInformation(whChatMessage);
		}
		out.print(returnStr);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		System.out.println("别，别进来");
		return "seccuss";
	}
}
