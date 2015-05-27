package com.thedeveloperworldisyours.colloquialisms.models;


import garin.artemiy.sqlitesimple.library.annotations.Column;

/**
 * Created by javiergonzalezcabezas on 23/5/15.
 */
public class Sentence {

    public transient static final String COLUMN_ID = "_id";
    public transient static final String COLUMN_SENTENCE_ORIGIN = "sentence_origin";
    public transient static final String COLUMN_SENTENCE_DESTINATION = "sentence_destination";
    public transient static final String COLUMN_LANGUAGE = "language";

    @Column(name = COLUMN_ID, isPrimaryKey = true)
    private int id;
    @Column(name = COLUMN_SENTENCE_ORIGIN)
    private String sentenceOrigin;
    @Column(name = COLUMN_SENTENCE_DESTINATION)
    private String sentenceDestination;
    @Column(name = COLUMN_LANGUAGE)
    private String language;

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public String getSentenceOrigin() {
        return sentenceOrigin;
    }

    public void setSentenceOrigin(String sentenceOrigin) {
        this.sentenceOrigin = sentenceOrigin;
    }

    public String getSentenceDestination() {
        return sentenceDestination;
    }

    public void setSentenceDestination(String sentenceDestination) {
        this.sentenceDestination = sentenceDestination;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
