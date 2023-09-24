package ru.danilov.project.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.danilov.project.entity.CompanyDocument;
import ru.danilov.project.repositories.DocumentRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private List<CompanyDocument> companyDocuments = new ArrayList<>();

    public List<CompanyDocument> listDocuments(String designation) {
        if (designation != null) return documentRepository.findByDesignation(designation);
        return documentRepository.findAll();
    }

    public List<CompanyDocument> listDocuments() {
        return companyDocuments;
    }

    public CompanyDocument specificDocument(Long id) {
    return documentRepository.findById(id).orElse(null);
    }

    public void saveDocumentCompany(CompanyDocument companyDocument) {
        log.info("Saving new {}", companyDocument);
        documentRepository.save(companyDocument);
    }

    public void deleteDocumentCompany(Long id) {
        documentRepository.deleteById(id);
    }

//    public void updateDocument(Long id, CompanyDocument updateDocument) {
//        CompanyDocument companyDocumentToBeUpdated = specificDocument(id);
//        companyDocumentToBeUpdated.setDescription(updateDocument.getDescription());
//        companyDocumentToBeUpdated.setDesignation(updateDocument.getDesignation());
//    }


}
