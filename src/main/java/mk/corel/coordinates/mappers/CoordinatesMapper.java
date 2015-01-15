package mk.corel.coordinates.mappers;
import java.io.IOException;
import java.util.List;

import mk.corel.coordinates.exceptions.ScaleException;
import mk.corel.coordinates.model.Coordinate;

public class CoordinatesMapper {
  
  public static void main(String [] args) {
    
    CoordinatesMapperMenu coordinatesMapperMenu = new CoordinatesMapperMenu();
    CoordinateMapperCalculator coordinateMapperCalculator = new CoordinateMapperCalculator();
    
    try {
      
      String scale = coordinatesMapperMenu.readScale();
      Coordinate axisValues = coordinatesMapperMenu.readAxisValues();
      Coordinate corelAxisValues = coordinatesMapperMenu.readCorelAxisValues();
      Integer coordinatesNumber = coordinatesMapperMenu.readCoordinatesNumber();
      List<Coordinate> coordinates = coordinatesMapperMenu.readCoordinates(coordinatesNumber);
      
      List<Coordinate> mappedCoordinates = coordinateMapperCalculator.convertValues(scale, axisValues, corelAxisValues, coordinates);
      
      coordinatesMapperMenu.printMappedCoordinates(mappedCoordinates);
      
    } catch (IOException e) {
      
      e.printStackTrace();
    } catch (ScaleException e) {
      
      System.out.println("Error: Invalid or unsupported scale!");
    }
  }
}
