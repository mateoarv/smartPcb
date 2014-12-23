package smartpcb;

public abstract class Units 
{
    public final int ppi = 72; 
    public static enum units
    {
        MM(25.4f),IN(1),PX(72);
        public final float factor;
        units(float inchFactor)
        {
            this.factor = inchFactor;            
        }
    }
    public static int toPixels(units startUnit,float value)
    {
        return (int) changeUnit(value,startUnit,units.PX);
    }
    public static float changeUnit(float val1,units unit1,units unit2)
    {
        return (val1*unit2.factor)/unit1.factor;
    }
}
