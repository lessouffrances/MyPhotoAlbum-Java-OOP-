package view;

import album.Snapshot;
import shapes.IShape;
import shapes.Oval;
import shapes.Rectangle;
import javax.swing.JPanel;
import java.awt.*;

/**
 * This is the DrawingPanel class.
 * It extends the JPanel interface.
 * It is designed to visually represent different shapes in the model.
 */
public class DrawingPanel extends JPanel {
    private Snapshot currentSnapshot;

    /**
     * This is the constructor for the DrawingPanel class.
     */
    public DrawingPanel(){
        super();
    }

    /**
     * This is the paintComponent() method.
     * @param g the <code>Graphics</code> object to protect
     * This method draws the panel whenever required.
     */
    @Override
    protected void paintComponent(Graphics g) {
        // call to the superclass method to handle the painting
        super.paintComponent(g);

        if (currentSnapshot == null){
            return;
        }
        for (IShape shape : currentSnapshot.getShapes()){
            g.setColor(shape.getColor());
            if (shape instanceof Rectangle){
                g.fillRect(shape.getX(),shape.getY()
                  , shape.getDimensionX()
                  , shape.getDimensionY());
            }
            else if (shape instanceof Oval){
                g.fillOval(shape.getX() - shape.getDimensionX() / 2
                  ,shape.getY() - shape.getDimensionY() / 2
                  , shape.getDimensionX(),shape.getDimensionY());
            }
        }
    }

    /**
     * This is the setCurrentSnapshot() method.
     * @param currentSnapshot is the Snapshot containing the shapes to be drawn.
     */
    public void setCurrentSnapshot(Snapshot currentSnapshot) {
        System.out.println(currentSnapshot.getShapes().size());
        this.currentSnapshot = currentSnapshot;
    }
}
