package smartpcb;

public class UnitNumber 
{
    private Units.units unit;
    private float value;
    public UnitNumber(float value,Units.units unit)
    {
        this.value = value;
        this.unit = unit;
    }
    public float getValue(Units.units unit)
    {
        return Units.changeUnit(value, this.unit, unit);
    }

    public Units.units getUnit() 
    {
        return unit;
    }
    
}
