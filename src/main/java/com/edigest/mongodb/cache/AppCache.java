package com.edigest.mongodb.cache;

import com.edigest.mongodb.entity.ConfigJournalAppEntity;
import com.edigest.mongodb.entity.JournalEntry;
import com.edigest.mongodb.repository.ConfigJournalApp;
import com.edigest.mongodb.repository.JournalEntryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppCache {
    public enum keys{
        WEATHER_API;
    }
    @Autowired
    ConfigJournalApp configJournalApp;

    public Map<String, String> APP_CACHE;

    @PostConstruct
    public void init() {
        APP_CACHE = new HashMap<>();
        for (ConfigJournalAppEntity configJournalAppEntity : configJournalApp.findAll()) {
            APP_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity
                    .getValue());
        }
    }
}
