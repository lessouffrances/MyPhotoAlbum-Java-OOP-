package controller;

import album.PhotoAlbum;

/**
 * This is the BaseCommand class.
 * It serves as the parent class for the concrete command classes.
 */
public class BaseCommand implements ICommand {

    protected PhotoAlbum album;
    protected String[] words;
    protected String line;

    /**
     * This is the constructor for BaseCommand class.
     * @param album is the photo album.
     * @param words are the actual tokenized input.
     * @param line is the line being processed.
     */
    public BaseCommand(PhotoAlbum album, String[] words, String line) {
        this.album = album;
        this.words = words;
        this.line = line;
    }

    /**
     * This is the execute() method.
     */
    @Override
    public void execute() {}
}
