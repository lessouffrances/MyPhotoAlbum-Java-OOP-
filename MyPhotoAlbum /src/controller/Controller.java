package controller;

import album.PhotoAlbum;
import album.Snapshot;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This is the Controller class.
 * It coordinates the commands from the input file and the photo album containing snapshots and shapes.
 */
public class Controller implements IController {
    private final int width;
    private final int height;
    private final PhotoAlbum album;
    private final BufferedReader bufferedReader;
    private String line;
    private String[] words; // tokenized
    private int currentSnapshotIndex = -1; // a pointer-like device

    /**
     * This is the constructor for the Controller class.
     * @param inputFileName is the name of the input file.
     * @param width is the width of the designated area.
     * @param height is the height of the designated area.
     */
    public Controller(String inputFileName, int width, int height) {

        this.width = width;
        this.height = height;
        album = new PhotoAlbum();

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // iterator-like processing
        while (hasMoreCommands()) {
            if (words[0].equals("shape")) {
                new ShapeCommand(album, words, line).execute();
            } else if (words[0].equals("move")) {
                new MoveCommand(album, words, line).execute();
            } else if (words[0].equals("color")) {
                new ColorChangeCommand(album, words, line).execute();
            } else if (words[0].equals("resize")) {
                new ResizeCommand(album, words, line).execute();
            } else if (words[0].equals("snapshot")) {
                new TakeSnapshotCommand(album, words, line).execute();
            }
        }
    }

    /**
     * This is the getWidth() method.
     * @return is the width of the designated area.
     */
    public int getWidth() {
        return width;
    }

    /**
     * This is the getHeight() method.
     * @return is the height of the designated area.
     */
    public int getHeight() {
        return height;
    }

    /**
     * This is the hasMoreCommands() method.
     * @return true if there are more commands to read; otherwise false.
     */
    private boolean hasMoreCommands() {
        while (true) {
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) { // simple error handling
                throw new RuntimeException(e);
            }

            // if there is no line
            if (line == null) {
                return false;
            }

            line = line.strip();
            if (line.startsWith("#") || line.equals("")) {
                continue;
            }

            // catch the key word
            words = Arrays.stream(line.split(" ")).filter(token -> !token.isEmpty()).toArray(String[]::new);
            words[0] = words[0].toLowerCase();
            if (words[0].equals("shape")
              || words[0].equals("move")
              || words[0].equals("color")
              || words[0].equals("resize")
              || words[0].equals("remove")
              || words[0].equals("snapshot")) {
                return true;
            }
        }
    }

    /**
     * This is the hasNextSnapshot() method.
     * @return true if there are snapshots; otherwise false.
     */
    public boolean hasNextSnapshot() {
        return currentSnapshotIndex + 1 <= album.getNumberOfSnapshots() - 1;
    }

    /**
     * This is the nextSnapshot() method.
     * It serves as a pointer-like device for snapshots.
     */
    public void nextSnapshot() {
        currentSnapshotIndex ++;
    }

    /**
     * This is the hasPreviousSnapshot() method.
     * @return true if it has; otherwise, false.
     */
    public boolean hasPreviousSnapshot() {
        return currentSnapshotIndex >= 1;
    }

    /**
     * This is the previousSnapshot() method.
     * It serves as a pointer-like device for snapshots.
     */
    public void previousSnapshot() {
        currentSnapshotIndex --;
    }

    /**
     * This is the getCurrentSnapshot() method.
     * @return the current snapshot.
     */
    public Snapshot getCurrentSnapshot() {
        if (currentSnapshotIndex == -1) {
            return null;
        }
        return album.getSnapshots().get(currentSnapshotIndex);
    }

    /**
     * This is the getSnapshotByIndex() method.
     * @param index is the index intended to get.
     * @return the Snapshot located at the index.
     */
    public Snapshot getSnapshotByIndex(int index) {
        currentSnapshotIndex = index;
        return getCurrentSnapshot();
    }

    /**
     * This is the getAllSnapshotTimestamps() method.
     * @return all the timestamps in a list of Strings.
     */
    public String[] getAllSnapshotTimestamps() {
        String[] timestamps = new String[album.getSnapshots().size()];
        for (int i = 0; i < album.getSnapshots().size(); i++) {
            timestamps[i] = album.getSnapshots().get(i).getTimestampString();
        }
        return timestamps;
    }
}
