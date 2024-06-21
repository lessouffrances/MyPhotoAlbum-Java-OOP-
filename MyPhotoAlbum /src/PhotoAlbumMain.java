import controller.Controller;
import view.GraphicalView;
import view.WebView;

/**
 * This is the photoAlbumMain class.
 * It triggers the window that displays the view, entry-point.
 */
public class PhotoAlbumMain {

    /**
     * This method is the main entry point of the application.
     * It parses command-line arguments and initializes the controller and view accordingly.
     *
     * @param args the command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        String in = "";
        String view = "";  // graphical or web
        String out = "";
        int xMax = 1000;
        int yMax = 1000;
        int index = 0;

        // loop through the arguments to parse information
        while (index < args.length) {
            // check if argument is input file path
            if (args[index].equals("-in")) {
                if (index + 1 < args.length) {
                    in = args[index + 1];
                    index += 2;
                }
                else {
                    // simple error handling
                    System.out.println("No name-of-command-file after -in!");
                    System.exit(1);
                }
            }
            // check if argument is view type
            else if (args[index].equals("-view")) {
                if (index + 1 < args.length) {
                    view = args[index + 1];
                    index += 2;
                }
                else {
                    // simple error handling
                    System.out.println("No type-of-view after -view!");
                    System.exit(1);
                }
            }
            // check if argument is output file path for web view
            else if (args[index].equals("-out")) {
                if (index + 1 < args.length) {
                    out = args[index + 1];
                    index += 2;
                }
                else {
                    System.out.println("No where-output-should-go after -out!");
                    System.exit(1);
                }
            }
            // exit the loop if not recognized
            else {
                break;
            }
        }
        // check if the remaining arguments specify custom xMax and yMax values
        if (index == args.length - 2) {
            try {
                // parse custom xMax
                xMax = Integer.parseInt(args[index++]);
                // parse custom yMax
                yMax = Integer.parseInt(args[index]);
            } catch (NumberFormatException e) {
                System.out.println("xmax or ymax cannot be converted to numbers");
                System.exit(1);
            }
        }
        // check if graphical view is selected
        if (view.equals("graphical")) {
            Controller controller = new Controller(in, xMax, yMax);
            GraphicalView graphicalView = new GraphicalView(controller);
            graphicalView.setVisible(true);
        }
        // check if web view is selected
        else if (view.equals("web")) {
            if (out.equals("")) {
                System.out.println("No output file was specified for web view");
                System.exit(1);
            }
            Controller controller = new Controller(in, xMax, yMax);
            WebView webView = new WebView(controller);
            webView.display(out);
        }
    }
}
