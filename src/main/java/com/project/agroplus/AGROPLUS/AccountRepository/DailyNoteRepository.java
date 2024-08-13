package com.project.agroplus.AGROPLUS.AccountRepository;

import com.project.agroplus.AGROPLUS.AccountModel.DailyNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyNoteRepository extends JpaRepository<DailyNote, Long> {
}
