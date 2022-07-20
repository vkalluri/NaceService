package com.nace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nace.exception.NaceException;
import com.nace.model.NaceDetails;
import com.nace.repository.NaceRepository;
import com.nace.repository.model.NaceModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NaceServiceImpl implements NaceService{

	@Autowired
	private NaceRepository naceRepository;


	/**
	 * Save nace details to db.
	 *
	 * @param naceDetails the nace details
	 * @return the string
	 */
	@Override
	public String saveNaceDetailsToDb(NaceDetails naceDetails) {
		log.debug("saving the data to DB");
		NaceModel model = new NaceModel();
		model.setCode(naceDetails.getCode());
		model.setDescription(naceDetails.getDescription());
		model.setExcludes(naceDetails.getExcludes());
		model.setExtraIncludes(naceDetails.getExtraIncludes());
		model.setIncludes(naceDetails.getIncludes());
		model.setLevel(naceDetails.getLevel());
		model.setOrderId(naceDetails.getOrderId());
		model.setParent(naceDetails.getParent());
		model.setReferencesDetails(naceDetails.getReferencesDetails());
		model.setRulings(naceDetails.getRulings());

		try {
			model = naceRepository.save(model);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new NaceException("Error connecting to DB", HttpStatus.BAD_REQUEST);
		}

		if (model != null) {
			return "Order " + model.getOrderId() + " is saved successfully";
		} else {
			return "Data not saved successfully";
		}
	}
	
	/**
	 * Gets the details by id.
	 *
	 * @param orderId the order id
	 * @return the details by id
	 */
	@Override
	public NaceDetails getDetailsById(long orderId) {
		NaceModel model = null;
		NaceDetails naceDetails = null;
		try {
			model = naceRepository.getReferenceById(orderId);
		} catch (Exception ex) {
			throw new NaceException("Error connecting to DB", HttpStatus.BAD_REQUEST);
		}
		
		if(model == null) {
			throw new NaceException("No Data found with id " + orderId, HttpStatus.BAD_REQUEST);
		}else {
			naceDetails = new NaceDetails();
			naceDetails.setCode(model.getCode());
			naceDetails.setDescription(model.getDescription());
			naceDetails.setExcludes(model.getExcludes());
			naceDetails.setExtraIncludes(model.getExtraIncludes());
			naceDetails.setIncludes(model.getIncludes());
			naceDetails.setLevel(model.getLevel());
			naceDetails.setOrderId(model.getOrderId());
			naceDetails.setParent(model.getParent());
			naceDetails.setReferencesDetails(model.getReferencesDetails());
			naceDetails.setRulings(model.getRulings());
		}
		
		return naceDetails;
	}

}
