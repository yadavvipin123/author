package com.example.bookauthormanytomany.repository;

import com.example.bookauthormanytomany.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    @Query("select b from BookEntity b left join fetch b.authorEntity where b.id=?1")
    Optional<BookEntity> findByQuery(Long id);

//    @EntityGraph(attributePaths = "authorEntity")
//    Optional<BookEntity> findAuthorById(Long id);
}
