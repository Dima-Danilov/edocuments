package ru.danilov.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilov.project.entity.CompanyDocument;

import java.util.List;
public interface DocumentRepository extends JpaRepository<CompanyDocument, Long> {
    List<CompanyDocument> findByDesignation(String designation);
}
