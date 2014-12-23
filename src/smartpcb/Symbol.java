package smartpcb;

import Interfaces.Drawable;
import Interfaces.SvgElement;
import Resources.SymbolResource;
import Xml.XmlTag;
import java.awt.Graphics;

public class Symbol implements SvgElement,Drawable
{
    private final SymbolResource symbolResource;
    private String id;
    private static final Counter counter = new Counter();
    public int x,y;
    
    public Symbol(SymbolResource symbolResource)
    {
        this.symbolResource = symbolResource;
    }
    
    @Override
    public XmlTag getRootTag() 
    {
        return symbolResource.getRootTag();
    }

    @Override
    public String getId() 
    {
        return id;
    }

    @Override
    public void draw(Graphics g) 
    {
        symbolResource.paint(g, x, y);
    }
    
}
