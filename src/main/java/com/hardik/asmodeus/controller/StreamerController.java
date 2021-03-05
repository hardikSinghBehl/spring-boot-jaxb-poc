package com.hardik.asmodeus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hardik.asmodeus.entity.Streamer;
import com.hardik.asmodeus.service.StreamerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StreamerController {

	private final StreamerService streamerService;

	@PostMapping("/v1/insert-streamers")
	public void insertStreamersFromXmlFile(
			@RequestPart(name = "file", required = true) final MultipartFile streamersXmlFile) {
		streamerService.insertStreamers(streamersXmlFile);
	}

	@GetMapping("/v1/streamers")
	public List<Streamer> getStreamers() {
		return streamerService.getStreamers();
	}

	@GetMapping("/v1/streamers-to-xml/{platformName}")
	public String getBase64XmlFileStringOfStreamers(
			@PathVariable(name = "platformName", required = true) final String platformName) {
		return streamerService.getXmlFileOfStreamersFromPlatform(platformName);
	}

}
