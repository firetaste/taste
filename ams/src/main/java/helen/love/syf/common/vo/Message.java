/**
 * 
 */
package helen.love.syf.common.vo;

/**
 * @author syf
 *
 */
public class Message { 
	/**消息级别:debug info warn error*/
	private String level;
	/**消息内容*/
	private String msg;
	/**执行结果 */
	private boolean success;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String msg) {
		super();
		this.msg = msg;
	}

	public Message(String level, String msg, boolean success) {
		super();
		this.level = level;
		this.msg = msg;
		this.success = success;
	}

	public Message(String level, String msg) {
		super();
		this.level = level;
		this.msg = msg;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Message m = new Message("a","b",true);
		System.out.println(m);
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"level\":\""+this.level+"\",\"msg\":\""+this.msg+"\",\"success\":"+this.success+"}";
	}

}
