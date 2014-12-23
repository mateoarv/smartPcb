package Components.Panels;

import Interfaces.TransformListener;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import smartpcb.CoordinateSystem;
import smartpcb.Point2D;
import smartpcb.Units;
import smartpcb.Utils;

public class PanelTranform implements MouseWheelListener,MouseListener,MouseMotionListener
{
    private float zoom,transX,transY;;
    private final float minZoom,maxZoom,zoomConstant;
    private final Component component;
    private final Point2D panPosition,clickPoint;
    private boolean panStarted;
    private final ArrayList<TransformListener> listeners;
    private final AffineTransform transform;
    private AffineTransform tempTransform;
    private final CoordinateSystem objectSystem;
    public PanelTranform(Component component)
    {
        this.component = component;
        panPosition = new Point2D();
        clickPoint = new Point2D();
        listeners = new ArrayList<>();
        transform = new AffineTransform();
        objectSystem = new CoordinateSystem(Units.units.MM);
        component.addMouseWheelListener(this);
        component.addMouseListener(this);
        component.addMouseMotionListener(this);
        zoom = 1;
        zoomConstant = 0.7f;
        minZoom = 0.1f;
        maxZoom = 7.5f;
    }
    
    public void startTransform(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        tempTransform = g2d.getTransform();
        updateTransform();
        g2d.transform(transform);
    }
    public void finishTransform(Graphics g)
    {
        ((Graphics2D)g).setTransform(tempTransform);
    }
    private void updateTransform()
    {
        transform.setToIdentity();
        transform.translate(transX, transY);
        transform.scale(zoom, zoom);
    }
    public void addListener(TransformListener listener)
    {
        listeners.add(listener);
    }
    private void notifyListeners()
    {
        for(TransformListener listener:listeners)
        {
            listener.transformed(zoom, transX, transY);
        }
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) 
    {
        int r = e.getWheelRotation();
        if(r!=0)
        {
            Point2D p1 = projectPoint(new Point2D(e.getPoint()));
            if(r<0)
                zoom*=zoomConstant;
            else
                zoom*=(2d-zoomConstant);
            zoom = Utils.fitInterval(zoom,minZoom,maxZoom);
            Point2D p2 = unProjectPoint(p1);
            transX += e.getX()-p2.x;
            transY += e.getY()-p2.y;
            notifyListeners();
            component.repaint();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) 
    {
        switch(e.getButton())
        {
            case 1:
                clickPoint.set(((float)e.getX())/zoom-transX,((float)e.getY())/zoom-transY);
                break;
            case 2:
                panStarted = true;
                panPosition.set(e.getPoint());
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        switch(e.getButton())
        {
            case 2:
                panStarted=false;
                break;
            case 3:
                break;
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e)
    {
        if(panStarted)
        {
            transX += (e.getX()-panPosition.x);
            transY += (e.getY()-panPosition.y);
            panPosition.set(e.getPoint());
            notifyListeners();
            component.repaint();
        }
    }
    public Point2D getClickPoint() 
    {
        return clickPoint;
    }
    public Point2D projectPoint(Point2D point)
    {     
        Point2D p = new Point2D(point);
        p.set((point.x-transX)/(zoom),(point.y-transY)/(zoom));
        return p;
    }
    public Point2D unProjectPoint(Point2D point)
    {
        Point2D p = new Point2D(point);
        p.set(point.x*(zoom)+transX,point.y*(zoom)+transY);
        return p;
    }    
}
