package com.hardik.asmodeus.service;

import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXB;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hardik.asmodeus.entity.Streamer;
import com.hardik.asmodeus.pojo.StreamerDto;
import com.hardik.asmodeus.pojo.StreamerWrapperDto;
import com.hardik.asmodeus.repository.MasterCountryRepository;
import com.hardik.asmodeus.repository.MasterPlatformRepository;
import com.hardik.asmodeus.repository.StreamerRepository;
import com.hardik.asmodeus.utility.XmlUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StreamerService {

	private final StreamerRepository streamerRepository;

	private final MasterCountryRepository masterCountryRepository;

	private final MasterPlatformRepository masterPlatformRepository;

	public void insertStreamers(MultipartFile streamersXmlFile) {
		final var streamerWrapperDto = XmlUtils.convert(streamersXmlFile);
		streamerWrapperDto.getStreamers().forEach(streamerDto -> {
			final var country = masterCountryRepository.findByIsoCode(streamerDto.getCountryCode()).orElseThrow();
			final var platform = masterPlatformRepository.findByNameIgnoreCase(streamerDto.getPlatform()).orElseThrow();
			final var streamer = streamerRepository
					.findByFullNameAndDateOfBirth(streamerDto.getName(), streamerDto.getDateOfBirth())
					.orElse(new Streamer());
			streamer.setCountryId(country.getId());
			streamer.setPlatformId(platform.getId());
			streamer.setDateOfBirth(streamerDto.getDateOfBirth());
			streamer.setFullName(streamerDto.getName());
			streamerRepository.save(streamer);
		});
	}

	public List<Streamer> getStreamers() {
		return streamerRepository.findAll();
	}

	public String getXmlFileOfStreamersFromPlatform(String platformName) {
		final var platform = masterPlatformRepository.findByNameIgnoreCase(platformName).orElseThrow();
		final var streamersOfPlatform = streamerRepository.findByMasterPlatformName(platform.getName()).parallelStream()
				.map(streamer -> {
					final var streamerDto = new StreamerDto();
					streamerDto.setCountryCode(streamer.getMasterCountry().getIsoCode());
					streamerDto.setDateOfBirth(streamer.getDateOfBirth());
					streamerDto.setName(streamer.getFullName());
					streamerDto.setPlatform(streamer.getMasterPlatform().getName());
					return streamerDto;
				}).collect(Collectors.toList());
		final var streamerWrapperDto = new StreamerWrapperDto();
		streamerWrapperDto.setStreamers(streamersOfPlatform);
		final var stringWriter = new StringWriter();
		JAXB.marshal(streamerWrapperDto, stringWriter);
		return Base64.encodeBase64String(stringWriter.toString().getBytes());
	}

}
