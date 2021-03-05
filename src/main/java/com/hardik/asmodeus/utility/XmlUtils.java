package com.hardik.asmodeus.utility;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.multipart.MultipartFile;

import com.hardik.asmodeus.pojo.StreamerWrapperDto;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class XmlUtils {
	
	public StreamerWrapperDto convert(MultipartFile multipartFile) {
		StreamerWrapperDto streamerWrapperDto = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(StreamerWrapperDto.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			streamerWrapperDto = (StreamerWrapperDto) jaxbUnmarshaller.unmarshal(multipartFile.getInputStream());
		} catch (JAXBException | IOException e) {
			log.error("UNABLE TO PROCESS XML FILE " + e);
		}
		return streamerWrapperDto;
		
	}

}
