package Resources;

import Xml.XmlTag;

public class SymbolResource extends SvgResource
{
    private final float[][] terminals;
    
    public SymbolResource(float[][] terminals,String name)
    { 
        super(new XmlTag("g"),name);
        this.terminals = terminals;
    }
    public float[][] getTerminals() 
    {
        return terminals;
    } 
}
