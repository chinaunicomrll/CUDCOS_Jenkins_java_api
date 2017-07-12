package com.cudcos.util;

/**
 * 
 * @author guojunl
 *
 */
public class CallResult {
	
	private String body;
	private int status;
	private long costtime;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getCosttime() {
		return costtime;
	}
	public void setCosttime(long costtime) {
	
		this.costtime = costtime;
	}
	@Override
	public String toString() {
		return "CallResult [body=" + body + ", status=" + status
				+ ", costtime=" + costtime + "]";
	}
	
}
