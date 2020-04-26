package com.modesty.jms;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.modesty.pojo.vo.Message;

/**
* @author Modesty
* @Version 2020年4月6日 下午11:10:26
*/
@Component
public class JmsComponent {
	@Autowired
	JmsMessagingTemplate messagingTemplate;

	@Autowired
	Queue queue;
	
	private static final Logger log = LoggerFactory.getLogger(JmsComponent.class);

	//添加消息到消息队列
	public void send(Message msg) {
		messagingTemplate.convertAndSend(this.queue, msg);
		log.info("Modesty[JMS]send msg:"+JSON.toJSONString(msg));
		
	}
	
	// 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "AMQ")
    // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    @SendTo("SQueue")
    public void handleMessage(Message msg) {
    	log.info("Modesty[JMS]receive msg:"+JSON.toJSONString(msg));
    }
	
}


/**
* Notes
*/
