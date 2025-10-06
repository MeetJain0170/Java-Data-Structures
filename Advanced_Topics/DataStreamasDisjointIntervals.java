import java.util.TreeMap;

public class DataStreamasDisjointIntervals {
    class Interval{
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public class DisjointIntervals{
        private final TreeMap<Integer, Interval> intervals;

        public DisjointIntervals() {
            intervals = new TreeMap<>();
        }

        public void addNum(int val){
            if(intervals.containsKey(val)){
                return; // Value already exists, no need to add
            }

            Integer leftStart = intervals.lowerKey(val);
            Integer rightStart = intervals.higherKey(val);

            boolean mergeLeft = leftStart != null && intervals.get(leftStart).end + 1 >= val;
            boolean mergeRight = rightStart != null && rightStart == val + 1;

            if(mergeLeft && mergeRight){
                Interval leftInterval = intervals.get(leftStart);
                Interval rightInterval = intervals.get(rightStart);
                leftInterval.end = rightInterval.end;
                intervals.remove(rightStart);
            } else if(mergeLeft) {
                Interval leftInterval = intervals.get(leftStart);
                leftInterval.end = Math.max(leftInterval.end, val);
            } else if(mergeRight) {
                Interval rightInterval = intervals.get(rightStart);
                intervals.put(val, new Interval(val, rightInterval.end));
                intervals.remove(rightStart);
            } else {
                intervals.put(val, new Interval(val, val));
            }
        }
        public int[][] getIntervals(){
            int [][] result = new int[intervals.size()][2];
            int i=0;
            for(Interval iv: intervals.values()){
                result[i][0] = iv.start;    
                result[i][1] = iv.end;
                i++;
            }return result;
        }
    }
}
