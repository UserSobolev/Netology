import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int valueForFilter;

    public Filter(int valueFilter) {
        this.valueForFilter = valueFilter;
    }

    List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        var tempList = new ArrayList<Integer>();
        for (int value : list) {
            if (value >= valueForFilter) {
                tempList.add(value);
                logger.log("элемент: " + value + " подходит");
            } else {
                logger.log("элемент: " + value + " не подходит");
            }
        }
        return tempList;
    }
}
