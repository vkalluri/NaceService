package com.nace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nace.api.NaceServiceApi;
import com.nace.model.NaceDetails;
import com.nace.service.NaceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class NaceServiceController implements NaceServiceApi{
	
	@Autowired
	private NaceService naceService;

	@Override
	public ResponseEntity<String> postNaceDetails(@RequestHeader NaceDetails naceDetails) {
		log.info("In postNaceDetails method with details {}", naceDetails);
		return new ResponseEntity<String>(naceService.saveNaceDetailsToDb(naceDetails), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<NaceDetails> getNaceDetailsById(@RequestParam long orderId) {
		log.info("In getNaceDetailsById method");
		return new ResponseEntity<NaceDetails>(naceService.getDetailsById(orderId), HttpStatus.OK);
	}

}
