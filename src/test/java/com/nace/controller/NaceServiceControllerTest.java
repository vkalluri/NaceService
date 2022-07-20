package com.nace.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nace.model.NaceDetails;
import com.nace.service.NaceService;

@ExtendWith(MockitoExtension.class)
public class NaceServiceControllerTest {
	
	@Mock
	private NaceService naceService;

	
	@InjectMocks
	private NaceServiceController naceServiceController;
	
	@Test
	public void postNaceDetailsShouldReturnSuccess() {
		when(naceService.saveNaceDetailsToDb(ArgumentMatchers.any(NaceDetails.class))).thenReturn("Success");
		ResponseEntity<String> response = naceServiceController.postNaceDetails(createRequest());
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getNaceDetailsByIdShouldReturnSuccess() {
		when(naceService.getDetailsById(ArgumentMatchers.any(Long.class))).thenReturn(createRequest());
		ResponseEntity<NaceDetails> response = naceServiceController.getNaceDetailsById(1l);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	
	private NaceDetails createRequest() {
		
		NaceDetails naceDetails = new NaceDetails();
		naceDetails.setCode("code");
		naceDetails.setDescription("description");
		naceDetails.setExcludes("excludes");
		naceDetails.setExtraIncludes("extraIncludes");
		naceDetails.setIncludes("includes");
		naceDetails.setLevel(3);
		naceDetails.setOrderId(1l);
		naceDetails.setParent("parent");
		naceDetails.setReferencesDetails("referencesDetails");
		naceDetails.setRulings("rulings");
		return naceDetails;
	}
}
