package view;

/**
 * This is the IWebView interface.
 * The concrete implementations are in the WebView class.
 */
public interface IWebView {

  /**
   * This is the display() method.
   * @param outputFileName the file that saves the HTML content to.
   */
  void display(String outputFileName);
}
