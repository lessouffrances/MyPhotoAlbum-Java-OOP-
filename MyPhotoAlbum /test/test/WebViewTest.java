package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import controller.Controller;
import org.junit.jupiter.api.Test;
import view.WebView;
import java.io.File;

/**
 * This is the test suite for the WebView class.
 * It simply tests if the display() method in the WebView class produces the required file.
 * "temp.html" is a temporary file.
 */
class WebViewTest {

    /**
     * This is the test case for the display() method.
     */
    @Test
    void display() {
        Controller controller = new Controller("buildings.txt",800,800);
        WebView webView = new WebView(controller);
        webView.display("temp.html");
        assertTrue(new File("temp.html").exists());
    }
}