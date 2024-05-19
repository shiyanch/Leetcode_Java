package MinimumFuelCostToReportToTheCapital;

import java.util.*;

public class MinimumFuelCostToReportToTheCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] road : roads) {
            List<Integer> list1 = map.getOrDefault(road[0], new ArrayList<>());
            list1.add(road[1]);
            map.put(road[0], list1);

            List<Integer> list2 = map.getOrDefault(road[1], new ArrayList<>());
            list2.add(road[0]);
            map.put(road[1], list2);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        long total = 0;

        for (int neighbor : map.get(0)) {
            total += travel(map, neighbor, visited, seats).fuel;
        }
        return total;
    }

    private Tuple travel(Map<Integer, List<Integer>> map, int city, Set<Integer> visited, int seats) {
        visited.add(city);
        int people = 1;
        int car = 0;
        long fuel = 0;

        if (!map.containsKey(city)) {
            return new Tuple(1, 1, 1);
        }

        for (int neighbor : map.get(city)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            Tuple curr = travel(map, neighbor, visited, seats);
            fuel += curr.fuel;
            people += curr.people;
            car += curr.cars;
        }

        if (car * seats >= people) {
            // No new car is needed at this city
            int adjustedCar = (people + seats - 1) / seats;
            return new Tuple(adjustedCar, people, fuel + adjustedCar);
        } else {
            return new Tuple(car + 1, people, fuel + car + 1);
        }
    }

    private static class Tuple {
        int cars;
        int people;
        long fuel;

        Tuple() {}
        Tuple(int cars, int people, long fuel) {
            this.cars = cars;
            this.people = people;
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) {
//        int[][] roads = {{3,1}, {3,2},{1,0},{0,4},{0,5},{4,6}};
        int[][] roads = {{0,1}, {0,2}, {1,3}, {1,4}};
        int seats = 5;

        System.out.println(new MinimumFuelCostToReportToTheCapital().minimumFuelCost(roads, seats));
    }
}
