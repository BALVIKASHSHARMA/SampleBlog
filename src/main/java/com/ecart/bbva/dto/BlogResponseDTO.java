package com.ecart.bbva.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BlogResponseDTO extends ResponseDTO {

	private Long id;

	private String content;

}
