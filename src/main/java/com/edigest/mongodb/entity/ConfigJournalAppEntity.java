package com.edigest.mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("config_journal_app")
public class ConfigJournalAppEntity {
    private String key;
    private String value;
}
