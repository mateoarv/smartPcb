package SaveObjects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartpcb.Dialog;

public class Project extends SaveObject
{
    private ArrayList<Circuit> circuits;
    private File location;
    private UUID id;
    
    public Project(File location,String name)
    {
        super(name,null);
        this.location = location;
        circuits = new ArrayList<Circuit>();
        circuits.add(new Circuit(this,"Circuit_1"));
        id = UUID.randomUUID();
    }
    
    public void addCircuit(Circuit circuit)
    {
        circuits.add(circuit);
    }
    public ArrayList<Circuit> getCircuits() 
    {
        return circuits;
    }
    public UUID getId() 
    {
        return id;
    }
    
    public void save()
    {
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(location);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            Dialog.error("There was a problem while trying to save the project.",ex);
        }
    }
    public static Project load(File location)
    {
        try 
        {
            FileInputStream fileInput = new FileInputStream(location);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Project project = null;
            project = (Project)objectInput.readObject();
            objectInput.close();
            fileInput.close();
            return project;
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            Dialog.error("The selected file was not found.",ex);
        } 
        catch (IOException | ClassNotFoundException ex)
        {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            Dialog.error("The selected project file seems to be corrupted.",ex);
        } 
        return null;
    }
}
