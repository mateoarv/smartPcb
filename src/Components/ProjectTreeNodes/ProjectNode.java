package Components.ProjectTreeNodes;

import java.util.ArrayList;
import SaveObjects.Circuit;
import SaveObjects.Project;

public class ProjectNode extends ProjectTreeNode
{ 
    public ProjectNode(Project project)
    {
        super(project.getName(),project);
        updateNodes();
    }
    public void updateNodes()
    {
        Project project = (Project)saveObject;
        this.removeAllChildren();
        ArrayList<Circuit> list = project.getCircuits();
        if(list.size()>0)
        {
            for(int i = 0;i<list.size();i++)
            {
                this.add(new CircuitNode(list.get(i)));
            }
        }
    }
    public Project getProject()
    {
        return (Project)saveObject;
    }
}
