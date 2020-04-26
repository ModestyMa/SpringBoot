package com.modesty.pojo.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
* @author Modesty
* @Version 2020年4月6日 下午11:21:04
*/

@Data
public class Message implements Serializable{
	private String content;
	private Date date;
}


/**
* Notes
*/
