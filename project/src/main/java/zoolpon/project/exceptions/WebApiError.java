package zoolpon.project.exceptions;

import java.util.List;

public class WebApiError {

	private String mainMessage;
	private List<String> messages;

	public WebApiError(String mainMessage, List<String> messages) {

		this.setMainMessage(mainMessage);
		this.setMessages(messages);

	}

	public WebApiError(String mainMessage) {
		this.setMainMessage(mainMessage);
	}

	public String getMainMessage() {
		return mainMessage;
	}

	public void setMainMessage(String mainMessage) {
		this.mainMessage = mainMessage;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
