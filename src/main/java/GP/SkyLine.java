package GP;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SkyLine {
    class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int heigth;
        boolean isStart;
//        public BuildingPoint(int x, int heigth, boolean isStart) {
//            this.x = x;
//            this.heigth = heigth;
//            this.isStart = isStart;
//        }
        @Override
        public int compareTo(@NotNull BuildingPoint o) {
            if(this.x != o.x)
                return  this.x - o.x;
            else {
                return (this.isStart ? -this.heigth : this.heigth) - (o.isStart ? -o.heigth : o.heigth);
            }
        }
    }
    public List<List<Integer>> getSkyLine(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int[] building : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].heigth = building[2];
            buildingPoints[index].isStart = true;

            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].heigth = building[2];
            buildingPoints[index+1].isStart = false;
            index +=2;
        }
        Arrays.sort(buildingPoints);
        TreeMap<Integer, Integer> queue = new TreeMap<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        queue.put(0,1);
        int prevMaxHeight = 0;
        LinkedHashMap<Integer, Integer> mp = new LinkedHashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(BuildingPoint buildingPoint: buildingPoints) {
            if(buildingPoint.isStart) {
                queue.compute(buildingPoint.heigth, (key, value) -> {
                    if(value != 1)
                        return value+1;
                    return 1;
                });
            }
            else {
                queue.compute(buildingPoint.heigth, (key, value) -> {
                    if(value == 1)
                        return null;
                    return value - 1;
                });
            }
            int currentMax = queue.lastKey();
            if(currentMax != prevMaxHeight) {
                List<Integer> newPoint = new ArrayList<>(Arrays.asList(buildingPoint.x, currentMax));
                result.add(newPoint);
                prevMaxHeight = currentMax;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] buildings = {{1,3,4}, {3,4,4}, {2,6,2}, {8,11,4}, {7,9,3}, {10,11,2}};
        SkyLine skyLine = new SkyLine();
        skyLine.getSkyLine(buildings);
    }
}
