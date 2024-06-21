package view;

import album.Snapshot;
import controller.Controller;
import shapes.IShape;
import shapes.Rectangle;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the WebView() class.
 * It generates an HTML file that represents snapshots.
 * Each snapshot contains multiple shapes and is displayed as an SVG within the HTML.
 */
public class WebView implements IWebView {
    private Controller controller;

    /**
     * This is the constructor for the WebView class.
     * @param controller the controller in this MVC architect, coordinating the view and the model.
     */
    public WebView(Controller controller) {
        this.controller = controller;
    }

    /**
     * This is the display() method.
     * @param outputFileName the file that saves the HTML content to.
     */
    public void display(String outputFileName) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
            // write HTML structures
            bufferedWriter.write("<!DOCTYPE html>\n");
            bufferedWriter.write("<html lang=\"en\">\n");
            bufferedWriter.write("<head>\n");
            bufferedWriter.write("    <meta charset=\"UTF-8\">\n");
            bufferedWriter.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            bufferedWriter.write("    <title>cs5004 Shapes Photo Album Viewer</title>\n");
            bufferedWriter.write("</head>\n");
            bufferedWriter.write("<body>\n");

            // process each snapshot using the controller
            while (controller.hasNextSnapshot()){
                controller.nextSnapshot();
                Snapshot snapshot = controller.getCurrentSnapshot();
                bufferedWriter.write("<svg width=\""+(controller.getWidth()+20)+"\" height=\""+(controller.getHeight()+60)+"\" xmlns=\"http://www.w3.org/2000/svg\">\n");
                bufferedWriter.write("    <rect x=\"5\" y=\"5\" width=\""+(controller.getWidth()+10)+"\" height=\""+(controller.getHeight()+50)+"\" fill=\"none\" stroke=\"red\" stroke-width=\"2\"/>\n");
                bufferedWriter.write("    <text x=\"5\" y=\"20\">"+snapshot.getTimestampString()+"</text>\n");
                bufferedWriter.write("    <text x=\"5\" y=\"40\">"+snapshot.getDescription()+"</text>\n");
                for (IShape shape : snapshot.getShapes()){
                    Color color = shape.getColor();
                    if (shape instanceof Rectangle){
                        bufferedWriter.write("<rect x=\""+(shape.getX()+10)+"\" y=\""+ (shape.getY()+50)+"\" width=\""+shape.getDimensionX()+"\" height=\""+shape.getDimensionY()+"\" fill=\"rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")\" />\n");
                    }
                    else{
                        bufferedWriter.write("<ellipse cx=\""+(shape.getX()+10)+"\" cy=\""+ (shape.getY()+50)+"\" rx=\""+shape.getDimensionX()+"\" ry=\""+shape.getDimensionY()+"\" fill=\"rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")\" />\n");
                    }
                }
                bufferedWriter.write("</svg>\n");
                bufferedWriter.write("<br>\n");
            }
            bufferedWriter.write("</body>\n");
            bufferedWriter.write("</html>\n");
            bufferedWriter.close();
            System.out.println("The generated html file is saved as "+outputFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
