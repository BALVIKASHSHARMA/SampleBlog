package com.ecart.bbva.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BlogRequestDTO extends RequestDTO {

	private Long id;

	private String content;

}
