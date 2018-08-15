package org.sha.model;

public enum EventSourceEnum {
	MOUSE("MOUSE"),KEYBOARD("KEYBOARD");
	private String sourceName;

	private EventSourceEnum(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	
}
