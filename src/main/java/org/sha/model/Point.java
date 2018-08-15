package org.sha.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value=Include.NON_NULL)
public class Point implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2294860617030223535L;
	private Integer x;
	private Integer y;
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Point(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point() {
		super();
	}
	
	
	
}
