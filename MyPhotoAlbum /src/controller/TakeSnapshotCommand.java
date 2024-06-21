package controller;

import album.PhotoAlbum;

/**
 * This is the TakeSnapshotCommand class.
 * It is one of the child classes of BaseCommand.
 */
public class TakeSnapshotCommand extends BaseCommand {

    /**
     * This is the constructor for TakeSnapshotCommand class.
     * @param album is the photo album.
     * @param words are the actual tokenized input.
     * @param line is the line being processed.
     */
    public TakeSnapshotCommand(PhotoAlbum album, String[] words, String line) {
        super(album, words, line);
    }

    /**
     * This is the execute() method.
     * It functions with the method takeSnapshot() in the PhotoAlbum class.
     */
    @Override
    public void execute() {
        line = line.toLowerCase();
        String description = line.substring(line.indexOf("snapshot") + "snapshot".length());
        album.takeSnapshot(description);
    }
}
