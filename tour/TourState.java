package tour;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import npuzzle.Tiles;
import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public boolean equals(Object that) {
		if (that instanceof TourState) {
			TourState t = (TourState) that;
			// since we've overriden hashcode in city,
			// visitedCities can be compared easily
			// same with currentCity
			// http://stackoverflow.com/questions/6187294/java-set-collection-override-equals-method
			return this.visitedCities.equals(t.visitedCities)
					&& t.currentCity.equals(this.currentCity);
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		// the hashcode of a set is the sum of the hashcodes in the set
		return visitedCities.hashCode() + currentCity.hashCode();
	}

	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}
}
