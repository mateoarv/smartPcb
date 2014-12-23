package Xml;

import smartpcb.Dialog;

public class XmlParser 
{
    private Stages currentStage;
    private int pos,length,counter;
    private String character,attName,svg;
    private StringBuilder builder;
    private XmlTag lastTag,rootTag,groupTag;
    private boolean ignoreSvgTag;
    
    public XmlParser(XmlTag rootTag)
    {
        currentStage = Stages.ROOT;
        counter = 0;
        this.rootTag = rootTag;
        groupTag = rootTag;
        builder = new StringBuilder();
        ignoreSvgTag=false;
    }
    private enum Stages
    {
        ROOT,A,B,C,D,E,F,G;
    }
    public void setIgnoreSvgTag(boolean ignoreSvgTag) 
    {
        this.ignoreSvgTag = ignoreSvgTag;
    }
    public XmlTag parse(String svg)
    {
        if(ignoreSvgTag)
            svg = svg.substring(svg.indexOf(">", svg.indexOf("<svg"))+1, svg.indexOf("</svg>"));
        else
            svg = svg.substring(svg.indexOf("<svg"), svg.indexOf("</svg>")+6);
    
        this.svg = svg;
        length = svg.length();
        pos = 0;
        boolean failed = false;
        while(pos<length && !failed)
        {
            character = svg.substring(pos, pos+1);
            //Dialog.print(currentStage.name());
            switch(currentStage)
            {
                case ROOT:
                    failed=root();
                    break;
                case A:
                    failed=a();
                    break;
                case B:
                    failed=b();
                    break;
                case C:
                    failed=c();
                    break;
                case D:
                    failed=d();
                    break;
                case E:
                    failed=e();
                    break;
                case F:
                    failed=f();
                    break;
                case G:
                    failed=g();
                    break;
            }
            pos++;
        }
        if(failed)
        {
            Dialog.print("parse failed: " + currentStage.name() + " pos: " + pos + " char: " + character);
            return null;
        }
        else
        {
            Dialog.print("parse finished");
            return rootTag;
        }
        
    }
    private boolean root()
    {
        if(character.matches("<"))
        {
            currentStage = Stages.A;
            if(builder.length()>0)
                groupTag.setContent(builder.toString());
            builder = new StringBuilder();
        }
        else if(character.matches("."))
            builder.append(character);
        return false;
    }
    private boolean a()
    {
        if(character.matches("[a-zA-Z]"))
        {
            currentStage = Stages.B;
            builder = new StringBuilder();
            b();          
        }
        else if(character.matches("/"))
        {
            currentStage = Stages.G;
            builder = new StringBuilder();
        }
        else
            return true;
        return false;
    }
    private boolean b()
    {
        if(builder.length() == 0)
        {
            if(character.matches("[a-zA-Z]"))
            {
                builder.append(character);
            }
            else return true;
        }
        else
        {
            if(character.matches("\\w"))
            {
                builder.append(character);
            }
            else if(character.matches("\\s"))
            {
                currentStage = Stages.C;
                lastTag = new XmlTag(builder.toString());
                groupTag.addChild(lastTag);
                builder = new StringBuilder();
            }
            else if(character.matches(">"))
            {
                currentStage = Stages.F;
                lastTag = new XmlTag(builder.toString());
                groupTag.addChild(lastTag);
                builder = new StringBuilder();
                f();
            }
            else return true;               
        }
        return false;
    }
    private boolean c()
    {
        if(builder.length()==0)
        {
            if(character.matches("[a-zA-Z]"))
            {
                builder.append(character);
            }
            else if(!character.matches("\\s"))
                return true;
        }
        else
        {
            if(character.matches("\\s") || character.matches("="))
            {
                attName = builder.toString();
                builder = new StringBuilder();
                currentStage = Stages.D;
                d();
            }
            else if(character.matches("[\\w:-]"))
            {
                builder.append(character);
            }
            else return true;
                
        }
        return false;
    }
    private boolean d()
    {
        if(character.matches("="))
        {
            currentStage = Stages.E;          
        }
        else if(!character.matches("\\s"))
            return true;
        return false;
    }
    private boolean e()
    {
        if(counter == 0)
        {
            if(character.matches("\""))
            {
                counter = 1;
            }
            else if(!character.matches("\\s"))
                return true;
        }
        else if(counter == 1)
        {
            if(character.matches("\"") ) //&& !svg.substring(pos-1, pos).matches("\\")
            {
                //probar ""
                lastTag.setAttribute(attName, builder.toString());
                builder = new StringBuilder();
                counter = 2;
            }
            else
                builder.append(character);

        }
        else
        {
            if(character.matches("[a-zA-Z]"))
            {
                currentStage = Stages.C;
                counter = 0;
                c();
            }
            else if(character.matches("[>/]"))
            {
                currentStage = Stages.F;
                counter = 0;
                f();
            }
            else if(!character.matches("\\s"))
                return true;
        }
        return false;
    }
    private boolean f()
    {
        if(character.matches(">"))
        {
            if(counter == 0)
            {
                groupTag = lastTag;
            }
            counter = 0;
            currentStage = Stages.ROOT;
        }
        else if(character.matches("/") && counter == 0)
        {
            counter = 1;
        }
        else return true;
        return false;
    }
    private boolean g()
    {
        if(counter == 0)
        {
            if(!character.matches("[a-zA-Z]"))
                return true;
            else
                counter = 1;
        }
        else
        {
            if(character.matches(">"))
            {
                if(groupTag.getParent()!=null)
                {
                    groupTag = groupTag.getParent();
                    counter = 0;
                    currentStage = Stages.ROOT;
                }
                else 
                {
                    
                    return true;
                }
            }
            else if(!character.matches("\\w"))
                return true;
        }
        return false;
    }
}
