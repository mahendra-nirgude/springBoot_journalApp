package com.edigest.mongodb.service;

import com.edigest.mongodb.entity.JournalEntry;
import com.edigest.mongodb.entity.User;
import com.edigest.mongodb.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepo;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry entry, String userName) {

        try {
            entry.setDate(LocalDateTime.now());
            User user = userService.findByUserName(userName);
            JournalEntry saved = journalEntryRepo.save(entry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println("Exception occured : " + e);
            throw new RuntimeException("An error occured while saving the entry." + e);
        }
    }

    public void saveEntry(JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while deleting the entry. ", e);
        }
        return removed;
    }

}
