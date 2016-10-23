package it304.parametermodel;

/**
 * 微信验证实体类
 * @author DK
 *
 */
public class WeChat {
	//包含token的字符串
	private String signature;
	// 时间戳
	private String timestamp;
	// 随机数
	private String nonce;
	// 随机字符串
	private String echostr;
	
	
	@Override
	public String toString() {
		return "WeChat [signature=" + signature + ", timestamp=" + timestamp + ", nonce=" + nonce + ", echostr="
				+ echostr + "]";
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	
}
