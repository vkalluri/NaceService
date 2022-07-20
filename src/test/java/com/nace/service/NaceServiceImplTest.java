package com.nace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.nace.exception.NaceException;
import com.nace.model.NaceDetails;
import com.nace.repository.NaceRepository;
import com.nace.repository.model.NaceModel;

@ExtendWith(MockitoExtension.class)
public class NaceServiceImplTest {
	
	@Mock
	private NaceRepository naceRepository;
	
	@InjectMocks
	private NaceServiceImpl naceServiceImpl;
	
	@Test
	public void saveNaceDetailsToDbShouldReturnSuccess() {
		when(naceRepository.save(ArgumentMatchers.any(NaceModel.class))).thenReturn(new NaceModel());
		String model = naceServiceImpl.saveNaceDetailsToDb(prepareData());
		assertNotNull(model);
		assertEquals(model, "Order 0 is saved successfully");
	}
	
	@Test
	public void saveNaceDetailsToDbShouldReturnError() {
		when(naceRepository.save(ArgumentMatchers.any(NaceModel.class))).thenThrow(new NaceException("Error connecting to DB", HttpStatus.BAD_REQUEST));
		NaceException exce = assertThrows(NaceException.class, () ->{
			naceServiceImpl.saveNaceDetailsToDb(prepareData());
		});
		assertNotNull(exce);
		assertEquals(exce.getMessage(), "Error connecting to DB");
	}

	@Test
	public void getDetailsByIdShouldReturnData() {
		when(naceRepository.getReferenceById(ArgumentMatchers.any(Long.class))).thenReturn(new NaceModel());
		NaceDetails details = naceServiceImpl.getDetailsById(1L);
		assertNotNull(details);
	}

	
	public NaceDetails prepareData() {
		NaceDetails naceDetails = new NaceDetails();
		naceDetails.setCode("code");
		naceDetails.setDescription("description");
		naceDetails.setExcludes("excludes");
		naceDetails.setExtraIncludes("extraIncludes");
		naceDetails.setIncludes("includes");
		naceDetails.setLevel(2);
		naceDetails.setOrderId(0l);
		naceDetails.setParent("parent");
		naceDetails.setReferencesDetails("referencesDetails");
		naceDetails.setRulings("rulings");
		return naceDetails;
	}
	
}
