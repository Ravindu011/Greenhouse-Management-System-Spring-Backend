package com.project.agroplus.AGROPLUS.AccountController;

import com.project.agroplus.AGROPLUS.AccountModel.DailyNote;
import com.project.agroplus.AGROPLUS.AccountRepository.DailyNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin
public class DailyNoteController {

    @Autowired
    private DailyNoteRepository dailyNoteRepository;

    // Add a new note
    @PostMapping("/addNote")
    public DailyNote addNote(@RequestBody DailyNote dailyNote) {
        return dailyNoteRepository.save(dailyNote);
    }

    // View all notes
    @GetMapping("/allNote")
    public List<DailyNote> getAllNotes() {
        return dailyNoteRepository.findAll();
    }

    // View note by ID
    @GetMapping("oneNote/{id}")
    public Optional<DailyNote> getNoteById(@PathVariable Long id) {
        return dailyNoteRepository.findById(id);
    }
}
