import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private static class CheckIn {
        String stationName;
        int time;

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class RouteData {
        double totalTime = 0;
        int count = 0;

        void addTrip(int duration) {
            totalTime += duration;
            count++;
        }

        double getAverage() {
            return totalTime / count;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, RouteData> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn startInfo = checkInMap.remove(id);
        String routeKey = startInfo.stationName + "->" + stationName;
        int travelTime = t - startInfo.time;

        routeMap.computeIfAbsent(routeKey, k -> new RouteData()).addTrip(travelTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        return routeMap.get(routeKey).getAverage();
    }
}
