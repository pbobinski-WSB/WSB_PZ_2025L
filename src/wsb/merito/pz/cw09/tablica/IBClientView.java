/**
 * 
 */
package wsb.merito.pz.cw09.tablica;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author kmi
 */
@SuppressWarnings("serial")
public class IBClientView extends Frame {
	
	private IBClientController controller = null;
	
    private IBClientModel model = null;

    public IBClientView(IBClientController controller, IBClientModel model, String title) {
    	super(title);
    	this.controller = controller;
    	this.model = model;
    }
    
    public void createView(int colorIndex, int width, int height) {
    	model.createModel(IBProtocol.colors[colorIndex], width, height);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        
        add(model, "West");
        Button b = new Button("clear");
        b.addActionListener((evt) -> model.clear());
        Panel p100 = new Panel();
        p100.add(b);
        b = new Button("logout");
        b.addActionListener((event) -> controller.forceLogout());
        Panel p200 = new Panel();
        p200.add(b);
        Panel p300 = new Panel(new BorderLayout());
        p300.add(p100, "North");
        p300.add(p200, "Center");
        add(p300, "East");
        pack();
        EventQueue.invokeLater(() -> setVisible(true));
    }
    
    public void updateTitle(String updateString) {
    	EventQueue.invokeLater(() -> setTitle(getTitle() + ":c" + updateString));
    }
    
    public void drawLine(int color, int x1, int y1, int x2, int y2) { 
    	model.drawLine(IBProtocol.colors[color], x1, y1, x2, y2);
    }
    
    @Override
    public void dispose() {
    	setVisible(false);
    	super.dispose();
    }
}
