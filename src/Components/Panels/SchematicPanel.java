package Components.Panels;

import Resources.SymbolResource;
import SaveObjects.Schematic;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import smartpcb.CoordinateSystem;
import smartpcb.Dialog;
import smartpcb.Grid;
import smartpcb.Point2D;
import smartpcb.Symbol;
import smartpcb.UnitNumber;
import smartpcb.Units;

public class SchematicPanel extends TabPanel
{
    private final SymbolResource symbolResource;
    private final ArrayList<Symbol> symbols;
    private boolean panStarted;
    private final PanelTranform panelTransform;
    private final Grid grid;
    private final CoordinateSystem system;
    
    public SchematicPanel(Schematic schematic)
    {
        super(schematic);
        symbols = new ArrayList<>();
        panelTransform = new PanelTranform(this);
        grid = new Grid(new UnitNumber(4,Units.units.MM),new UnitNumber(this.getWidth(),Units.units.PX),new UnitNumber(this.getHeight(),Units.units.PX));
        system = new CoordinateSystem(Units.units.MM);
        panelTransform.addListener(grid);
        panelTransform.addListener(system);
        float[][] points  = {{3.99f,11.99f},{3.99f,28.01f},{28.01f,3.99f},{28.01f,35.98f},{52,20}};
        symbolResource = new SymbolResource(points,"OpAmp");
        symbolResource.loadFromFile(new File("C:\\Users\\Mateo\\Documents\\Programación\\SmartPcb\\testing\\OpAmpInst.svg"));
        setListeners();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        grid.drawGrid(g);
        panelTransform.startTransform(g);
        for(Symbol symbol:symbols)
            symbol.draw(g);
        panelTransform.finishTransform(g);
    }
    public void addSymbol(Symbol symbol)
    {
        symbols.add(symbol);
        repaint();
    }
    private void setListeners()
    {
        this.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e)
            {

            }
            @Override
            public void mouseReleased(MouseEvent e)
            {
                switch(e.getButton())
                {
                    case 1:
                        Symbol symbol = new Symbol(symbolResource);
                        Point2D p = panelTransform.projectPoint(new Point2D(e.getPoint()));
                        //Point2D p = system.projectPoint(new Point2D(e.getPoint()), Units.units.PX);
                        p = grid.snapPoint(p.x, p.y);
                        Dialog.print(e.getPoint());
                        Dialog.print(p);
                        symbol.x = p.getRoundX();
                        symbol.y = p.getRoundY();
                        addSymbol(symbol);
                        break;
                    case 2:
                        
                        if(panStarted)
                        {
                            panStarted = false;
                            System.out.println("finished");
                        }
                        break;
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        this.addComponentListener(new ComponentListener()
        {
            @Override
            public void componentResized(ComponentEvent e) 
            {
                grid.setSize(new UnitNumber(getWidth(),Units.units.PX), new UnitNumber(getHeight(),Units.units.PX));
                repaint();
            }
            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentShown(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }
}
