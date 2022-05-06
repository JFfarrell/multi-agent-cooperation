
import astra.term.ListTerm;
import astra.term.Primitive;


public class Methods extends astra.core.Module {
    @TERM
    @ACTION
    public int random(int min, int max) {
        int random = (int) (Math.random() * (max - min + 1) + min);
        
        return random;
    }

    @ACTION
    public boolean add(ListTerm list, ListTerm object) {
        list.add(Primitive.newPrimitive(object));
        return true;
    }

    @TERM
    @ACTION
    public boolean grid(ListTerm grid) { 
        int lowerLimit = 0;
        int upperLimit = 2;
        for (int step = 0; step < 4; step++) {
            ListTerm row = new ListTerm();
            for (int y = lowerLimit; y < upperLimit; y++) {
                for (int x = 0; x < 16; x++) {
                    ListTerm current = new ListTerm();
                    current.add(Primitive.newPrimitive(x));
                    current.add(Primitive.newPrimitive(y));
                    row.add(current);
                }
            }
            grid.add(row);
            upperLimit += 2;
            lowerLimit += 2;
        }
        return true;
    }

    @TERM
    @ACTION
    public boolean reverseGrid(ListTerm reverseGrid) { 
        int lowerLimit = 7;
        int upperLimit = 9;
        for (int step = 0; step < 4; step++) {
            ListTerm row = new ListTerm();
            for (int y = lowerLimit; y < upperLimit; y++) {
                for (int x = 15; x >= 0; x--) {
                    ListTerm current = new ListTerm();
                    current.add(Primitive.newPrimitive(x));
                    current.add(Primitive.newPrimitive(y));
                    row.add(current);
                }
            }
            reverseGrid.add(row);
            upperLimit -= 2;
            lowerLimit -= 2;
        }
        return true;
    }
}
