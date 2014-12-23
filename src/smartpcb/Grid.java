package smartpcb;

import Interfaces.TransformListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Grid implements TransformListener
{
    private float zoom,spacePx,width,height,cx,cy,transX,transY,space;
    private final Color color;
    private int temp,roundWidth,roundHeight;
    private boolean display;
    private ArrayList<Float> posX,posY;
    private Units.units unit;
    
    public Grid(UnitNumber space,UnitNumber width,UnitNumber height)
    {
        posX = new ArrayList<>();
        posY = new ArrayList<>();
        setSpace(space);
        setSize(width,height);
        Dialog.print(this.width);
        color = Color.LIGHT_GRAY;
        zoom = 1;
        display = true;
        unit = space.getUnit();
    }
    public void drawGrid(Graphics g)
    {
        if(display)
        {
            Graphics2D g2d = (Graphics2D)g;
            posX.clear();
            posY.clear();
            g.setColor(color);
            for(int i = 0;i<cx;i++)
            {
                temp = (int) Math.round(i*spacePx*zoom);
               // g.drawLine(temp+transX, 0,temp+transX, (int) (roundHeight));
                g2d.draw(new Line2D.Double(i*spacePx*zoom+transX,0,i*spacePx*zoom+transX,roundHeight));
                posX.add(i*spacePx*zoom);
            }
            for(int j = 0;j<cy;j++)
            {
                temp = (int) Math.round(j*spacePx*zoom);
                g2d.draw(new Line2D.Double(0,j*spacePx*zoom+transY, roundWidth,j*spacePx*zoom+transY));
                posY.add(j*spacePx*zoom);
            }
        }   
        
    }

    @Override
    public void transformed(float zoom, float transX, float transY) 
    {
        this.zoom = zoom;
        cx = (float) (width/(spacePx*zoom)+1f);
        cy = (float) (height/(spacePx*zoom)+1f);
        display = !(spacePx*zoom<5);
        this.transX = transX%(spacePx*zoom);
        this.transY = transY%(spacePx*zoom);        
    }
    public final void setSize(UnitNumber width,UnitNumber height)
    {
        this.width = (float) width.getValue(Units.units.PX);
        this.height = (float) height.getValue(Units.units.PX);
        cx = this.width/this.spacePx+1f;
        cy = this.height/this.spacePx+1f;
        roundWidth = Math.round(this.width);
        roundHeight = Math.round(this.height);
    }
    public final void setSpace(UnitNumber space)
    {
        this.spacePx = (float) space.getValue(Units.units.PX);
        this.space = (float) space.getValue(space.getUnit());
        System.out.println("Space: " + this.spacePx);
    }

    public void setDisplay(boolean display) 
    {
        this.display = display;
    }
    
    /**
     * @param x,y: posición proyectada en pixeles
     * @return: posición en las unidades iniciales.
     */
    public Point2D snapPoint(float x,float y)
    {
        Dialog.print(posX);
        Dialog.print(posY);
        x = (int) Math.round(Units.changeUnit(x, Units.units.PX, Units.units.MM));
        y = (int) Math.round(Units.changeUnit(y, Units.units.PX, Units.units.MM));
        Dialog.print(x);
        float cx = Math.round((float)x/space);
        float cy = Math.round((float)y/space);
        Point2D p = new Point2D();
        p.set(cx*space,cy*space);
        return p;
    }
}
