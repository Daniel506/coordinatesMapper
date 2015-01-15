package mk.corel.coordinates.mappers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import mk.corel.coordinates.exceptions.InvalidScaleException;
import mk.corel.coordinates.exceptions.ScaleException;
import mk.corel.coordinates.exceptions.UnsupportedScaleException;
import mk.corel.coordinates.model.Coordinate;
import mk.corel.coordinates.model.Scale;

public class CoordinatesMapperMenu {
  
  public CoordinatesMapperMenu() {
    System.out.println("===== Corel Draw Coordinates Mapper =====");
  }
  
  public Integer readCoordinatesNumber() throws IOException {
    
    System.out.println("Enter the number of coordinates");
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    
    return Integer.valueOf(line);
  }
  
  public List<Coordinate> readCoordinates(int coordinatesNumber) throws IOException {
    System.out.println("Enter the coordinates, separated with white space:");
    
    List<Coordinate> coordinates = new ArrayList<Coordinate>();
    for (int index = 0; index < coordinatesNumber; index++) {
      coordinates.add(readCoordinate());
    }
    
    return coordinates;
  }
  
  public void printMappedCoordinates(List<Coordinate> coordinates) {
    System.out.println("The mapped coordinates are:");
    System.out.println("    Y     X    ");
    
    for (Coordinate coordinate : coordinates) {
      System.out.println(String.format("%s %s", coordinate.getY(), coordinate.getX()));
    }
  }
  
  public String readScale() throws IOException, ScaleException {
    
    System.out.println("Enter the scale in format 1:X");
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    
    if (!line.matches("1:\\d+")) throw new InvalidScaleException();
    
    if (ArrayUtils.contains(Scale.values(), line)) throw new UnsupportedScaleException();
    
    return line;
  }
  
  public Coordinate readAxisValues() throws IOException {
    
    System.out.println("Enter the coordinate axis value, separated with white space:");
    return readCoordinate();
  }
  
  public Coordinate readCorelAxisValues() throws IOException {
    
    System.out.println("Enter the coordinate corel value, separated with white space:");
    return readCoordinate();
  }


  public Coordinate readCoordinate() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    
    return new Coordinate(line);
  }
}
