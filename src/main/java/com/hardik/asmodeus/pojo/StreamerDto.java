package com.hardik.asmodeus.pojo;
import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.hardik.asmodeus.adapter.LocalDateAdapter;

import lombok.Data;

@XmlRootElement(name = "streamer")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class StreamerDto implements Serializable{

	private static final long serialVersionUID = 5283120219905711013L;

	@XmlAttribute(name = "country_code", required = true)
	private String countryCode;
	
	@XmlAttribute(name = "platform", required = true)
	private String platform;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@XmlAttribute(name = "date_of_birth", required = false)
	private LocalDate dateOfBirth;
	
	@XmlValue
	private String name;

}