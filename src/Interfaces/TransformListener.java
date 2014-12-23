package Interfaces;
/**
 * Interfaz usada para avisarle a los listeners cuando se produce un cambio en
 * la tranformación del panel.
 * @author Mateo
 */
public interface TransformListener 
{
    public void transformed(float zoom,float transX,float transY);

}
