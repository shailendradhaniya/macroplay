package org.sha.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class EventInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6843820219509412049L;
	private Integer sequenceNumber;
	private String eventSource;
	private Integer mouseButton; //1 for left click 2 for right click
	private Character keyButton;
	private Integer inputKeyCode;
	private String textInput;
	private Character enterInput;
	private Point clickPoint;
	private Integer inputKeyModifier;
	private Long delaySeconds; // milli second
	public String getEventSource() {
		return eventSource;
	}
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	public String getTextInput() {
		return textInput;
	}
	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}
	public Point getClickPoint() {
		return clickPoint;
	}
	public void setClickPoint(Point clickPoint) {
		this.clickPoint = clickPoint;
	}
	public void setMouseButton(Integer mouseButton) {
		this.mouseButton = mouseButton;
	}
	public void setKeyButton(Character keyButton) {
		this.keyButton = keyButton;
	}
	public void setEnterInput(Character enterInput) {
		this.enterInput = enterInput;
	}
	public Integer getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public Long getDelaySeconds() {
		return delaySeconds;
	}
	public void setDelaySeconds(Long delaySeconds) {
		this.delaySeconds = delaySeconds;
	}
	public Integer getMouseButton() {
		return mouseButton;
	}
	public Character getKeyButton() {
		return keyButton;
	}
	public Character getEnterInput() {
		return enterInput;
	}
	public Integer getInputKeyCode() {
		return inputKeyCode;
	}
	public void setInputKeyCode(Integer inputKeyCode) {
		this.inputKeyCode = inputKeyCode;
	}
	public Integer getInputKeyModifier() {
		return inputKeyModifier;
	}
	public void setInputKeyModifier(Integer inputKeyModifier) {
		this.inputKeyModifier = inputKeyModifier;
	}
	
	
}
