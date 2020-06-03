package com.onlinebookstore.bookstore.repository;

import com.onlinebookstore.bookstore.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Long>{
}
