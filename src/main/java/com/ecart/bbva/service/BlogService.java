package com.ecart.bbva.service;

import java.util.List;

import com.ecart.bbva.dto.RequestDTO;
import com.ecart.bbva.dto.ResponseDTO;

public interface BlogService<REQ extends RequestDTO, RES extends ResponseDTO> {

	List<RES> getAll();
	RES get(REQ request);
	RES save(REQ request);
	RES update(REQ request);
	RES delete(REQ request);

}
