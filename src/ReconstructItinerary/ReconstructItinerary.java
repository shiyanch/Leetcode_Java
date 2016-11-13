package ReconstructItinerary;

import java.util.*;

/**
 * 332. Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order.
 *
 * All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * Note:
 * 1. If there are multiple valid itineraries,
 * you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *
 * 2. All airports are represented by three capital letters (IATA code).
 * 3. You may assume all tickets form at least one valid itinerary.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        for(ArrayList<String> target : map.values()) {
            Collections.sort(target);
        }

        return DFS(map, new ArrayList<>(), "JFK", tickets.length+1);
    }

    private List<String> DFS(Map<String, ArrayList<String>> map, List<String> currList, String current, int stops) {
        currList.add(current);
        if(currList.size() == stops) {
            return currList;
        }

        if(!map.containsKey(current) || map.get(current).isEmpty()) {
            return null;
        }

        ArrayList<String> arrivals = map.get(current);

        for(int i=0;i<arrivals.size();i++) {
            String arrival = arrivals.get(i);
            arrivals.remove(i);
            List<String> path = DFS(map, currList, arrival, stops);
            if(path != null) {
                return path;
            }
            currList.remove(currList.size()-1);
            arrivals.add(i, arrival);
        }

        return null;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }
}
