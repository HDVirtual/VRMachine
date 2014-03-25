package registers;

public class IntRegister {
    private int data;


    public IntRegister()
    {
        data = 0;
    }
    
    public void set(int value)
    {
        this.data = value;
    }


    public int get()
    {
        return data;
    }
    
    public void clear()
    {
        data = 0;
    }
}
