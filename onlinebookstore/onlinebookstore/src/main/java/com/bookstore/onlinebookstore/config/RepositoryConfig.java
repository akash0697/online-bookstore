package com.bookstore.onlinebookstore.config;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.bookstore.onlinebookstore.entity.Book;

import javax.persistence.metamodel.Type;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
							.map(Type::getJavaType)
							.toArray(Class[]::new));
	}
}
