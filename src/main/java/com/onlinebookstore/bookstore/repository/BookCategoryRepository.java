package com.onlinebookstore.bookstore.repository;

import com.onlinebookstore.bookstore.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//this annotation is to change the default endpoints provided by spring data rest..
//by default, spring data rest will not expose ID in the json response however they appear in the links body in json in the url
@RepositoryRestResource(collectionResourceRel = "bookCategory",path = "book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory,Long>{
}
