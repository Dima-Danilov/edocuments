package ru.danilov.project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.danilov.project.entity.CompanyDocument;
import ru.danilov.project.service.DocumentService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("")
    public String allDocumentsCompany(@RequestParam(name = "designation", required = false) String designation2, Model model){
        model.addAttribute("companyDocuments", documentService.listDocuments(designation2));
        //Получим перечень всех документов, зарегистрированных в системе
        return "allDocumentsCompany/listDocuments";
    }

    @GetMapping("/{id}")
    public String showDocument(@PathVariable("id") Long id, Model model) {
        //Получим конкретный документ по его id из DAO и передадим на отображение в представление
        model.addAttribute("companyDocument", documentService.specificDocument(id));
        return "allDocumentsCompany/specificDocument";
    }
    @GetMapping ("/new")
    public String newDocument(Model model){
        model.addAttribute("document", new CompanyDocument());
        return "allDocumentsCompany/newDocument";
    }
    @PostMapping ("")
    public String createDocument(@ModelAttribute("document") CompanyDocument companyDocument){
        documentService.saveDocumentCompany(companyDocument);
        return "redirect:/documents";
    }


    @GetMapping("/{id}/edit")
    public String editDocument(Model model, @PathVariable("id") Long id){
        model.addAttribute("companyDocument", documentService.specificDocument(id));
        return "allDocumentsCompany/editDocument";
    }

    @PostMapping("/{id}")
    public String updateDocument (@ModelAttribute("companyDocument") CompanyDocument companyDocument, @PathVariable("id") Long id){
        documentService.saveDocumentCompany(companyDocument);
        return "redirect:/documents";
    }

    @PostMapping("/delete/{id}")
    public String deleteDocument(@PathVariable Long id){
        documentService.deleteDocumentCompany(id);
        return "redirect:/documents";
    }
}
