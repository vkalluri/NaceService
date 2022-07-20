package com.nace.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nace.model.NaceDetails;

import io.swagger.annotations.Api;

@Api(value = "nace")
public interface NaceServiceApi {

	@PostMapping(value = "/postNaceDetails", produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
	ResponseEntity<String> postNaceDetails(@RequestBody NaceDetails naceDetails);

	@GetMapping("/getNaceDetails")
	ResponseEntity<NaceDetails> getNaceDetailsById(@RequestParam long orderId);

}
