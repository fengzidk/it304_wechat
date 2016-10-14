package it304.bo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it304.model.WeChat;
import it304.util.wechat.SignUtil;



/**
 * 微信消息的入口
 * @author DK
 *
 */
@Controller
@RequestMapping("/weixin")
public class WeiXinEntrance {
	@RequestMapping(value="/api",method = RequestMethod.GET)
	@ResponseBody
	public String xxtInterface(WeChat wc){
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
        	System.out.println(((long)System.currentTimeMillis()-start)+"ms");
            return echostr;  
        } else {  
            System.out.println("不是微信服务器发来的请求,请小心!");  
            return null;
        }  
	}
	@RequestMapping(value="/test",method = RequestMethod.GET)
	@ResponseBody
	public String test(){
		System.out.println("别，别进来");
		return "seccuss";
	}
}
