/**
 * @author Mohammad Danyal
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Hashtable;
import java.util.Iterator;

	/**
	 * The root interface in the graph hierarchy. A mathematical graph-theory graph
	 * object G(V,E) contains a set V of vertices and a set
	 * E of edges. Each edge e=(v1,v2) in E connects vertex v1 to vertex v2.
	 *
	 * Through generics, a graph can be typed to specific classes for vertices
	 * V and edges E<T>. Such a graph can contain
	 * vertices of type V and all sub-types and Edges of type
	 * E and all sub-types.
	 */

	public class Graph<V, E> implements GraphInterface<Town, Road> {
	
	Hashtable<Integer, Town> townHashTable;
	Hashtable<Integer, Road> roadHashTable;
		
	int numOfNodes = 0;
	
	ArrayList<Town> visitedTowns;
	ArrayList<Town> unvisitedTowns;

	/**
	 * No-arg constructor
	 */
	public Graph() {
		
		townHashTable = new Hashtable<Integer, Town>();
		roadHashTable = new Hashtable<Integer, Road>();
		
		visitedTowns = new ArrayList<Town>();
		unvisitedTowns = new ArrayList<Town>();
	}

	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		
		// Loop through the road hash table
		for (Road roadIterator : roadHashTable.values()) {
			
			if ( (roadIterator.getSource().equals(sourceVertex) && roadIterator.getDestination().equals(destinationVertex)) || (roadIterator.getSource().equals(destinationVertex) && roadIterator.getDestination().equals(sourceVertex)) ) {
				
				return roadIterator;
			}
			
		}
		
		return null;
	}

	 /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		
		Road addRoad = new Road(sourceVertex, destinationVertex, weight, description);
		
		roadHashTable.put(addRoad.hashCode(), addRoad);
		
		townHashTable.get(sourceVertex.getName().hashCode()).getRoadList().add(addRoad);
		
		townHashTable.get(destinationVertex.getName().hashCode()).getRoadList().add(addRoad);
		
		// FIX THIS RETURN
		return null;
	}

	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		
		townHashTable.put(v.hashCode(), v);
		
		return true;
	}

	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		
//		if ( ((sourceVertex.equals(sourceVertex)) && !(sourceVertex.equals(destinationVertex))) || ((sourceVertex.equals(destinationVertex)) && !(sourceVertex.equals(sourceVertex))) ) {
			
				// Loop through the road hash table
				for (Road roadIterator : roadHashTable.values()) {
					
					if ( (roadIterator.getSource().equals(sourceVertex) && roadIterator.getDestination().equals(destinationVertex)) || (roadIterator.getSource().equals(destinationVertex) && roadIterator.getDestination().equals(sourceVertex)) ) {
						
						return true;
					}
					
				}
			
//			}
		
		return false;
	}

	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		
		for (Town townIterator : townHashTable.values()) {
			
			if (townIterator.getName().equals(v.getName())) {
				
				return true;
			}
			
		}
		
		return false;
	}

	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		
		Set<Road> roadHashTableToSet = new HashSet<Road>();
		
		for (Road roadIterator : roadHashTable.values()) {
			
			roadHashTableToSet.add(roadIterator);
		}
		
		return roadHashTableToSet;
	}

	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		
		Set<Road> roadsFromTowns = new HashSet<Road>();
		
		for (Road roadIterator : roadHashTable.values()) {
			
			if ( (roadIterator.getSource().equals(vertex)) || (roadIterator.getDestination().equals(vertex)) ) {
				
				roadsFromTowns.add(roadIterator);	
			}
		}
	
		return roadsFromTowns;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
	
		// Use iterator as using a for loop makes it difficult to remove edge from the list
		Iterator<Road> roadIterator = roadHashTable.values().iterator();
		
		Road nextInRoadHashTable;
		
		while (roadIterator.hasNext()) {
			
			nextInRoadHashTable = roadIterator.next();
			
			if ( (nextInRoadHashTable.getSource().equals(sourceVertex) && nextInRoadHashTable.getDestination().equals(destinationVertex)) || (nextInRoadHashTable.getSource().equals(destinationVertex) && nextInRoadHashTable.getDestination().equals(sourceVertex)) ) {
				
				if ( (nextInRoadHashTable.getWeight() > -1) && (nextInRoadHashTable.getName() != null) ) {
					
					// Call the remove() method after calling the next() method
					roadIterator.remove();
					
					return nextInRoadHashTable;
				}
				
			}
			
		}

		return null;	
	}

	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		
		// Use iterator as using a for loop makes it difficult to remove edge from the list
		Iterator<Town> townIterator = townHashTable.values().iterator();
		
		Town nextInTownHashTable;
		
		while (townIterator.hasNext()) {
			
			nextInTownHashTable = townIterator.next();
			
			if (nextInTownHashTable.equals(v)) {
				
				townIterator.remove();
				
				return true;
			}
			
		}
		
		return false;
	}

	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		
		Set<Town> townSet = new HashSet<Town>();
		
		for (Town townIterator : townHashTable.values()) {
			
			townSet.add(townIterator);
		}
		
		return townSet;
	}

	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		
		ArrayList<String> returnList = new ArrayList<String>();
		
		String tempStr = "";
		int tempWeight = 0;
		Town currentTown = null;
		
		dijkstraShortestPath(sourceVertex);
		
		for (Town townIterator : townHashTable.values()) {
			
				if (townIterator.equals(destinationVertex)) {
					
					currentTown = townIterator;
				}
		}
		
		while (currentTown.getPreviousTown() != null) {
			
			tempStr += currentTown.getPreviousTown() + " via ";
			
			for (Road roadIterator : roadHashTable.values()) {
			
				// Find the road that connects current road and current road previous town
				if ( (roadIterator.getSource().equals(currentTown.getPreviousTown()) && (roadIterator.getDestination().equals(currentTown))) || ((roadIterator.getSource().equals(currentTown)) && roadIterator.getDestination().equals(currentTown.getPreviousTown())) ) {
					
					tempStr += roadIterator.getName() + " to ";
					
					tempWeight = roadIterator.getWeight();
					
				}		
			}
			
			// add the current town's name to tempStr
			tempStr += currentTown.getName() + " ";
			
			// add the current town's weight to tempStr
			tempStr += tempWeight + " mi";
			
			returnList.add(tempStr);
			
			tempStr = "";
			
			// Update current town
			currentTown = currentTown.getPreviousTown();
		}
		
			// Reverse the list, as we are traveling in opposite direction
			Collections.reverse(returnList);
		
			return returnList;
		}

	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
		// Reset values inside of towns list
		for (Town townIterator : townHashTable.values()) {
			
			if (townIterator.equals(sourceVertex)) {
				
				// if it's the source then the distance to itself is 0
				townIterator.setTotalDistance(0);
				
				townIterator.setPreviousTown(null);
			}
			
			else {
				
				// if it's not the source then set the distance to infinity
				townIterator.setTotalDistance(Integer.MAX_VALUE);
				
				townIterator.setPreviousTown(null);
			}
			
		}
		
		// Loop to fill the unvisited town list
		for (Town townIterator : townHashTable.values()) {
			
			unvisitedTowns.add(townIterator);
		}
		
		while (unvisitedTowns.isEmpty() == false) {
			
			Town smallestTown = unvisitedTowns.get(0);
			
				// Loop to find smallest town
				for (int i = 0; i < unvisitedTowns.size(); i++) {
					
						
						if (smallestTown.getTotalDistance() > unvisitedTowns.get(i).getTotalDistance()) {
							
							smallestTown = unvisitedTowns.get(i);
						}
				}
			
				// Current town is basically the smallest town, and the smallest town is where we start
				Town currentTown = smallestTown;
				
				ArrayList<Road> currentTownRoads = currentTown.getRoadList();
		
				for (int i = 0; i < currentTownRoads.size(); i++) {
					
						Town source = currentTownRoads.get(i).getSource();
						Town destination = currentTownRoads.get(i).getDestination();
						Town nextVertex = null;
						
							if ( ((source.equals(currentTown)) == false) && (destination.equals(currentTown)) ) {
								
								nextVertex = source;
							}
							
							if ( (source.equals(currentTown) && ((destination.equals(currentTown))  == false)) ) {
								
								nextVertex = destination;
							}
					
							// Calculated distance of vertex
							int tempRoadWeight = (currentTown.getTotalDistance() + currentTownRoads.get(i).getWeight());
							
							if (tempRoadWeight < nextVertex.getTotalDistance()) {
								
								nextVertex.setTotalDistance(tempRoadWeight);
								
								nextVertex.setPreviousTown(currentTown);
								
								nextVertex.setPreviousRoad(currentTownRoads.get(i));
							}
				}
				
				visitedTowns.add(currentTown);
				unvisitedTowns.remove(currentTown);
		}
		
	}
	
	/**
	 * 
	 * @param hashCode the towns hash code
	 * @return the town at the hash code
	 */
	public Town getTown(int hashCode) {
		
		
		return townHashTable.get(hashCode);
	}
	
	/**
	 * 
	 * @return the road hash table
	 */
	public Hashtable<Integer, Road> returnRoadHashTable() {
		
		return roadHashTable;
	}
}
