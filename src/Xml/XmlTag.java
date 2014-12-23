package Xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.Element;

public class XmlTag 
{
    private final String name;
    private String content;
    private XmlTag parent;
    private final ArrayList<XmlTag> children;
    private final HashMap attributes;
    private boolean print;
    
    public XmlTag(String name)
    {
        this.name = name;
        children = new ArrayList<>();
        attributes = new HashMap();
        content = "";
        print = true;
    }
    public void addChild(XmlTag tag)
    {
        children.add(tag);
        tag.setParent(this);
    }
    public void setParent(XmlTag tag)
    {
        this.parent = tag;
    }
    public void setAttribute(String name,String value)
    {
        attributes.put(name, value);
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public String getAttribute(String name)
    {
        return (String)attributes.get(name);
    }
    public String toString(int tabIndex)
    {
        StringBuilder builder = new StringBuilder();
        String tab = "";
        for(int i = 0;i<tabIndex;i++)
            builder.append("\t");
        tab = builder.toString();
        builder = new StringBuilder();
        if(print)
        {
            builder.append(tab);
            builder.append("<");
            builder.append(name);          
            Iterator it = attributes.entrySet().iterator();
            while(it.hasNext())
            {
                Entry pair = (Entry)it.next();
                builder.append(" ");
                builder.append(pair.getKey());
                builder.append("=\"");
                builder.append(pair.getValue());
                builder.append("\"");
            }
        }
        if(children.size()>0)
        {
            if(print)
            {
                 builder.append(">\n");
                 //builder.append(content);
            }
            for (XmlTag child : children) {
                builder.append(child.toString(tabIndex+1));
            }
            if(print)
            {
                builder.append(tab);
                builder.append("</");
                builder.append(name);
                builder.append(">\n");
            }
        }
        else
        {
            if(print)
            {
                if(content.equals(""))
                {
                    builder.append("/>\n");
                }
                else
                {
                    builder.append(">");
                    builder.append(content);
                    builder.append("</");
                    builder.append(name);
                    builder.append(">\n");
                }
            }
        }
        return builder.toString();
    }
    @Override
    public String toString() 
    {
        return toString(-1);
    }
    public XmlTag getByAttribute(String attribute,String value)
    {
        XmlTag tag = null;
        int size = children.size();
        int i = 0;
        if(attributes.get(attribute)!=null && attributes.get(attribute).equals(value))
        {
            tag = this;
        }
        else
        {
            while(tag == null && i<size)
            {
                tag = children.get(i).getByAttribute(attribute, value);
                i++;
            }
        }
        return tag;
    }

    public String getName() 
    {
        return name;
    }
    public XmlTag getParent() 
    {
        return parent;
    }
    public void setPrint(boolean print)
    {
        this.print = print;
    }
    public boolean hasChildren()
    {
        return children.size()>0;
    }
    public void appendToElement(Element parent)
    {
        Element element = parent.getOwnerDocument().createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI,name);
        Iterator it = attributes.entrySet().iterator();
        while(it.hasNext())
        {
            Entry pair = (Entry)it.next();
            element.setAttributeNS(null,(String)pair.getKey(),(String)pair.getValue());
        }
        for(XmlTag child:children)
            child.appendToElement(element);
        parent.appendChild(element);
    }
    public XmlTag getFirstChild()
    {
        return children.get(0);
    }
}
