package com.ecart.bbva.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.bbva.constant.NoRecordsError;
import com.ecart.bbva.constant.ServiceError;
import com.ecart.bbva.dto.BlogRequestDTO;
import com.ecart.bbva.dto.BlogResponseDTO;
import com.ecart.bbva.entity.Blog;
import com.ecart.bbva.exteption.ServiceException;
import com.ecart.bbva.repository.BlogRepository;
import com.ecart.bbva.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService<BlogRequestDTO, BlogResponseDTO> {

	@Autowired
	private BlogRepository repo;

	@Override
	public BlogResponseDTO save(BlogRequestDTO request) {
		BlogResponseDTO dto = new BlogResponseDTO();
		Blog b = new Blog();
		b.setId(request.getId());
		b.setContent(request.getContent());

		Blog saved = repo.save(b);

		if (saved != null) {
			dto.setId(saved.getId());
		} else {
			throw new ServiceException(ServiceError.NOT_SAVED.getCode(), ServiceError.NOT_SAVED.getMessage());
		}

		return dto;
	}

	@Override
	public BlogResponseDTO update(BlogRequestDTO request) {
		BlogResponseDTO dto = new BlogResponseDTO();
		Optional<Blog> b = repo.findById(request.getId());
		if (b.isPresent()) {
			try {
				dto.setId(save(request).getId());
			} catch (Exception e) {
				throw new ServiceException(ServiceError.NOT_UPDATED.getCode(), ServiceError.NOT_UPDATED.getMessage());
			}
		} else {
			throw new ServiceException(NoRecordsError.EMPTY_RESPONSE.getCode(),
					NoRecordsError.EMPTY_RESPONSE.getMessage());
		}
		return dto;
	}

	@Override
	public BlogResponseDTO delete(BlogRequestDTO request) {
		BlogResponseDTO dto = new BlogResponseDTO();
		Optional<Blog> b = repo.findById(request.getId());
		if (b.isPresent()) {
			try {
				repo.deleteById(request.getId());
			} catch (Exception e) {
				throw new ServiceException(ServiceError.NOT_DELETED.getCode(), ServiceError.NOT_DELETED.getMessage());
			}
			Blog deleted = b.get();
			dto.setId(deleted.getId());
		} else {
			throw new ServiceException(ServiceError.NOT_DELETED.getCode(), ServiceError.NOT_DELETED.getMessage());
		}
		return dto;
	}

	@Override
	public List<BlogResponseDTO> getAll() {

		List<BlogResponseDTO> list = new ArrayList<>();

		Iterable<Blog> allBlogs = repo.findAll();

		allBlogs.forEach(e -> {
			BlogResponseDTO dto = new BlogResponseDTO();
			dto.setId(e.getId());
			dto.setContent(e.getContent());
			list.add(dto);
		});

		if (list.isEmpty()) {
			throw new ServiceException(NoRecordsError.EMPTY_RESPONSE.getCode(),
					NoRecordsError.EMPTY_RESPONSE.getMessage());
		}

		return list;
	}

	@Override
	public BlogResponseDTO get(BlogRequestDTO request) {
		BlogResponseDTO dto = new BlogResponseDTO();

		Optional<Blog> blog = repo.findById(request.getId());

		if (blog.isPresent()) {
			Blog b = blog.get();
			dto.setId(b.getId());
			dto.setContent(b.getContent());
		} else {
			throw new ServiceException(NoRecordsError.EMPTY_RESPONSE.getCode(),
					NoRecordsError.EMPTY_RESPONSE.getMessage());
		}

		return dto;
	}

}
