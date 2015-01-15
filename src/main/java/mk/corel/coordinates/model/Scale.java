package mk.corel.coordinates.model;



public enum Scale {
  
  SCALE_1000("1:1000", 1.0),
  SCALE_25000("1:25000", 0.04),
  SCALE_50000("1:50000", 0.02),
  SCALE_100000("1:100000", 0.01);
  
  private String scale;
  private Double rate;
  
  private Scale(String scale, Double rate) {
    this.scale = scale;
    this.rate = rate;
  }

  public String getScale() {
    return scale;
  }

  public Double getRate() {
    return rate;
  }

  public static Double getRateForScale(String scale) {
    
    for (Scale scaleObject : Scale.values()) {
      if (scaleObject.getScale().equals(scale)) {
        return scaleObject.getRate();
      }
    }
    
    return null;
  }
}
