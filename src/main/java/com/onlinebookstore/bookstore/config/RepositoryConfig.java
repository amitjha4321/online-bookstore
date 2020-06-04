package com.onlinebookstore.bookstore.config;

import com.onlinebookstore.bookstore.entity.Book;
import com.onlinebookstore.bookstore.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

    @Autowired
    private EntityManager entityManager;

    @Override
    //by default, spring data rest will not expose ID in the json response however they appear in the links body in json in the url
    //so to expose id in the json response we need to override this method for Book entity class
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.exposeIdsFor(Book.class);
//        config.exposeIdsFor(BookCategory.class);


        //this way is not good if we have many java entity classes so we will make use of entityManager
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
                .map(Type::getJavaType).toArray(Class[]::new));
    }
}
