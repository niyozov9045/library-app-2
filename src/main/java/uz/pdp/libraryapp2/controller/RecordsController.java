package uz.pdp.libraryapp2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.libraryapp2.dao.RecordsDao;
import uz.pdp.libraryapp2.model.Records;

import java.util.List;

@Component
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordsController {

    private final RecordsDao recordsDao;

    @GetMapping
    public String getAllRecords(Model model) {
        List<Records> allRecordsFromDb = recordsDao.getALLRecordsFromDb();
        model.addAttribute("recordList",allRecordsFromDb);
        return "records/view-records-form";
    }

    @GetMapping("/get-form")
    public String getRecordsForm() {
        return "records/add-records-form";
    }

    @PostMapping
    public String addNewRecords(Records records) {
        recordsDao.addNewRecords(records);
        return "redirect:/records";

    }

    @GetMapping("/edit/{id}")
    public String getFormEditRecords(@PathVariable Integer id, Model model) {
        Records recordsById = recordsDao.getRecordsById(id);
        model.addAttribute("records", recordsById);
        return "/records/edit-records-form";

    }

    @GetMapping("/edit")
    public String editRecordById(Records records) {
        recordsDao.editRecords(records);
        return "redirect:/records";
    }

    @GetMapping("/delete")
    public String deleteRecords(@PathVariable Integer id) {
        recordsDao.deleteRecords(id);
        return "redirect:/records";
    }
}
