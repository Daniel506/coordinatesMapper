package mk.corel.coordinates.mappers;
import java.util.ArrayList;
import java.util.List;

import mk.corel.coordinates.model.Coordinate;
import mk.corel.coordinates.model.Scale;



public class CoordinateMapperCalculator {
  
  public List<Coordinate> convertValues(String scale, Coordinate axisValue, Coordinate corelAxisValue, List<Coordinate> coordinates) {
    
    Double rate = Scale.getRateForScale(scale);
    
    List<Coordinate> mappedCoordinates = new ArrayList<Coordinate>();
    
    for (Coordinate coordinate : coordinates) {
      
      Double mappedX = corelAxisValue.getX() + (coordinate.getX() - axisValue.getX()) * rate;
      Double mappedY = corelAxisValue.getY() + (coordinate.getY() - axisValue.getY()) * rate;
      
      mappedCoordinates.add(new Coordinate(mappedX, mappedY));
    }
    
    return mappedCoordinates;
  }
}
