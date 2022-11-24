package challnege.event.Crosscuting.messages;

import challnege.event.Crosscuting.messages.enumeration.MessageLevel;
import static challnege.event.Crosscuting.helper.StringHelper.applyTrim;
import static challnege.event.Crosscuting.helper.StringHelper.EMPTY;
import static challnege.event.Crosscuting.helper.ObjectHelper.getDefaultIfNull;

public class Message {

	private MessageLevel level;
	private String content;
	
	public Message() {
		setLevel(MessageLevel.FATAL);
		setContent(EMPTY);
	}
	
	public Message(MessageLevel level, String content) {
		super();
		setLevel(level);
		setContent(content);
	}

	public MessageLevel getLevel() {
		return level;
	}
	
	public static Message createFatalMessage(final String content) {
		return new Message(MessageLevel.FATAL, content);
	}
	
	public static Message createErrorMessage(final String content) {
		return new Message(MessageLevel.ERROR, content);
	}
	
	public static Message createWarningMessage(final String content) {
		return new Message(MessageLevel.WARNING, content);
	}
	
	public static Message createInfoMessage(final String content) {
		return new Message(MessageLevel.INFO, content);
	}
	
	public static Message createSuccessMessage(final String content) {
		return new Message(MessageLevel.SUCCESS, content);
	}
	public void setLevel(final MessageLevel level) {
		this.level = getDefaultIfNull(level, MessageLevel.FATAL);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = applyTrim(content);
	}
}
