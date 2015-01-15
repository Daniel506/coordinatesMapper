package mk.corel.coordinates.exceptions;


public class UnsupportedScaleException extends ScaleException {
  
  public UnsupportedScaleException() {
    super();
  }
  
  public UnsupportedScaleException(String message) {
    super(message);
  }
  
  public UnsupportedScaleException(String message, Throwable exception) {
    super(message, exception);
  }
}
