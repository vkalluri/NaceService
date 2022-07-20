package com.nace.service;

import com.nace.model.NaceDetails;

public interface NaceService {
	
	String saveNaceDetailsToDb(NaceDetails naceDetails);
	NaceDetails getDetailsById(long orderId);

}
