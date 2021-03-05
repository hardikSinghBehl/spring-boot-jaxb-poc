package com.hardik.asmodeus.pojo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement(name = "streamers")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class StreamerWrapperDto implements Serializable{

	private static final long serialVersionUID = -6310860871167375108L;
	
	@XmlElement(name = "streamer")
	private List<StreamerDto> streamers;		
}