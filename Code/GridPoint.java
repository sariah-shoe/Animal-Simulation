package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Class to represent an x and y grid location.
 * 
 * TODO: Should have standard methods: equals, toString, hashCode, compareTo
 */
public class GridPoint implements Comparable<GridPoint>{
	// Create the instance variables
	private int x;
	private int y;
	private boolean occupied;
	
	// Constructor that makes x and y
	public GridPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Compare to function TODO: I don't like how it works but I'm not quite sure how I want it to work
	public int compareTo(GridPoint that)
	{
		// TODO: make this better, must match equals()
		if(this.x < that.x) {
			return(-1);
		}
		else if(this.x > that.x) {
			return(1);
		}
		else if(this.y > that.y) {
			return(2);
		}
		else if(this.y < that.y) {
			return(-2);
		}
		else {
			return 0;
		}
	}
	
	// Getter for x
	public int get_x() {
		return(this.x);
	} 
	
	// Getter for y
	public int get_y() {
		return(this.y);
	} 
	
	// A string that prints x and y
	public String toString() {
		return("x:" + this.x + " y:" + this.y);
	}
	
	// Compares objects to see if its matching x and y
	public boolean equals(Object o) {
		// Check to see if the object is a GridPoint
		GridPoint grid = null;
		if(o instanceof GridPoint) {
			grid = (GridPoint)o;
		}
		// If it is a gridpoint, see if x and y grid locations are the same
		if(this.x == grid.x && this.y == grid.y) {
			return(true);
		}
		return(false);
	}
	
	// Hashes the object
	public int hashCode() {
		return(Objects.hash(this.x, this.y));
	}
	
	public List<GridPoint> getNeighbors(int levels, TerrainMap tm){
		List<GridPoint> return_list = new ArrayList<GridPoint>();
		Map<GridPoint, TerrainTile> theTiles = tm.getTheTiles();
		
		// Loop through for every level
		for(int i = 1; i < levels + 1; i ++) {
			// Check to see if x + i is within bounds
			if(this.x + i <= TerrainMap.gridWidth) {
				
				// See if x + i is occupied, if so add it to my list
				if(new GridPoint((this.x + i), (this.y)).occupied) {
					return_list.add(new GridPoint((this.x + i), (this.y)));
				}
				
				// See if y + i is within bounds
				if (this.y + i <= TerrainMap.gridHeight) {
					// See if x + i, y + i, is occupied, if so add it to my list
					if(new GridPoint((this.x + i), (this.y + i)).occupied) {
						return_list.add(new GridPoint((this.x + i), (this.y + i)));
					}
					
					// If I am not on the first level, loop through and get my side values
					if(i > 1) {
						for(int j = 1; j < i; j++) {
							if(new GridPoint((this.x + i), (this.y + j)).occupied) {
								return_list.add(new GridPoint((this.x + i), (this.y + j)));
							}
						}
					}
				}
				
				// See if y - i is within bounds
				if (this.y - i >= TerrainMap.gridHeight) {
					// See if x, y - i is occupied, if so add it to my list
					if(new GridPoint((this.x + i), (this.y - i)).occupied) {
						return_list.add(new GridPoint((this.x + i), (this.y - i)));
					}
					
					// If I am not on the first level, loop through and get my side values
					if(i > 1) {
						for(int j = -1; j < (-1*i); j--) {
							if(new GridPoint((this.x + i), (this.y - j)).occupied) {
								return_list.add(new GridPoint((this.x + i), (this.y - j)));
							}
						}
					}
				}
			}
			
			// Check to see if x - i is within bounds
			if(this.x - i >= TerrainMap.gridWidth) {
				
				// See if x - i is occupied, if so add it to my list
				if(new GridPoint((this.x - i), (this.y)).occupied) {
					return_list.add(new GridPoint((this.x - i), (this.y)));
				}
				
				// If I am not on the first level, get my side values
				
				// See if y + i is within bounds
				if (this.y + i <= TerrainMap.gridHeight) {
					// See if x - i, y + i, is occupied, if so add it to my list
					if(new GridPoint((this.x - i), (this.y + i)).occupied) {
						return_list.add(new GridPoint((this.x - i), (this.y + i)));
					}
					
					// If I am not on the first level, loop through and get my side values
					if(i > 1) {
						for(int j = 1; j < i; j++) {
							if(new GridPoint((this.x - i), (this.y + j)).occupied) {
								return_list.add(new GridPoint((this.x - i), (this.y + j)));
							}
						}
					}
				}
				
				// See if y - i is within bounds
				if (this.y - i >= TerrainMap.gridHeight) {
					// See if x - i, y - i is occupied, if so add it to my list
					if(new GridPoint((this.x - i), (this.y - i)).occupied) {
						return_list.add(new GridPoint((this.x - i), (this.y - i)));
					}
					
					// If I am not on the first level, loop through and get my side values
					if(i > 1) {
						for(int j = -1; j < (-1 * i); j--) {
							if(new GridPoint((this.x + i), (this.y + j)).occupied) {
								return_list.add(new GridPoint((this.x + i), (this.y + j)));
							}
						}
					}
				}
			}
			
			// See if y + i is within bounds
			if(this.y + i <= TerrainMap.gridHeight) {
				// See if x, y + i is occupied, if so add it to my list
				if(new GridPoint((this.x), (this.y + i)).occupied) {
					return_list.add(new GridPoint((this.x), (this.y + i)));
				}
				
				// If I'm not on the first level, get my side values
				if(i > 1) {
					
					if (this.x - i >= TerrainMap.gridWidth) {
						for (int j = 1; j < i; j++) {
							if(new GridPoint((this.x - j), (this.y + i)).occupied) {
								return_list.add(new GridPoint((this.x - j), (this.y + i)));
							}	
						}	
					}
					
					if (this.x + i <= TerrainMap.gridWidth) {
						for (int j = 1; j < i; j++) {
							if(new GridPoint((this.x + j), (this.y + i)).occupied) {
								return_list.add(new GridPoint((this.x + j), (this.y + i)));
							}	
						}	
					}
				}
			}
			
			// See if y - i is within bounds
			if(this.y - i >= TerrainMap.gridHeight) {
				// See if x, y - i is occupied, if so add it to my list
				if(new GridPoint((this.x), (this.y - i)).occupied) {
					return_list.add(new GridPoint((this.x), (this.y - i)));
				}	
				
				// If I'm not on the first level, get my side values
				if(i > 1) {
					
					if (this.x - i >= TerrainMap.gridWidth) {
						for (int j = 1; j < i; j++) {
							if(new GridPoint((this.x - j), (this.y - i)).occupied) {
								return_list.add(new GridPoint((this.x - j), (this.y - i)));
							}	
						}	
					}
					
					if (this.x + i <= TerrainMap.gridWidth) {
						for (int j = 1; j < i; j++) {
							if(new GridPoint((this.x + j), (this.y - i)).occupied) {
								return_list.add(new GridPoint((this.x + j), (this.y - i)));
							}	
						}	
					}
				}
			}
		}
		
		return(return_list);
	}
	
	// Setter for occupation of a grid point
	public void setOccupied(boolean set) {
		if(set) {
			this.occupied = true;
		}
		else {
			this.occupied = false;
		}
	}
}
