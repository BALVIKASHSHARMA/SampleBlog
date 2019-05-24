package com.ecart.bbva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecart.bbva.entity.Blog;

@Repository
public interface BlogRepository
		extends
			CrudRepository<Blog, Long> {

}
