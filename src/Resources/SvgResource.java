package Resources;

import Xml.XmlParser;
import Xml.XmlTag;
import com.kitfox.svg.SVGCache;
import com.kitfox.svg.app.beans.SVGIcon;
import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import java.io.StringReader;
import smartpcb.Utils;

public class SvgResource implements Serializable
{
    protected final XmlTag rootTag;
    protected final String name;
    protected final SVGIcon icon;
    
    public SvgResource(XmlTag rootTag,String name)
    {
        this.rootTag = rootTag;
        this.name = name;
        icon = new SVGIcon();
        icon.setAntiAlias(true);
    }
    public XmlTag getRootTag() 
    {
        return rootTag;
    }
    public String getName() 
    {
        return name;
    }
    public void loadFromFile(File file)
    {
        rootTag.setPrint(false);
        XmlParser parser = new XmlParser(rootTag);
        parser.setIgnoreSvgTag(false);
        parser.parse(Utils.loadStringFile(file));
        updateIcon();
    }
    protected void updateIcon()
    {
        StringReader reader = new StringReader(rootTag.toString());
        icon.setSvgURI(SVGCache.getSVGUniverse().loadSVG(reader, "myImage"));
    }
    public void paint(Graphics g,int x,int y)
    {
        icon.paintIcon(null, g, x, y);
        
        //g.drawImage(image, x, y, null);
    }

}
