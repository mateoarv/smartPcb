package SaveObjects;

import java.io.Serializable;

public abstract class SaveObject implements Serializable
{
    protected String name;
    protected Project project;
    
    public SaveObject(String name,Project project)
    {
        this.name = name;
        this.project = project;
        if(this.project == null)
            this.project = (Project)this;
    }
    public String getName() 
    {
        return name;
    }
    
}
