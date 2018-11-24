package sample;

public class Hotel {
  private String name;
  private double stars;
  private String address;
  private String city;
  private String zipCode;
  private String state;
  private String country;
  private String website;

  public Hotel(String name, double stars, String address, String city, String state, String zipCode,
               String country, String website) {
    this.name = name;
    this.stars = stars;
    this.address = address;
    this.city = city;
    this.zipCode = zipCode;
    this.state = state;
    this.country = country;
    this.website = website;
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public double getStars() {
    return stars;
  }

  public void setStars(double stars) {
    this.stars = stars;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  @Override
  public String toString() {
    return "Hotel{" +
        "name='" + name + '\'' +
        ", stars=" + stars +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", state='" + state + '\'' +
        ", country='" + country + '\'' +
        ", website='" + website + '\'' +
        '}';
  }

  public String toDatabaseQueryString() {
    return
        "('" + name + '\'' +
        "," + stars +
        ",'" + address + '\'' +
        ",'" + city + '\'' +
        ",'" + state + '\'' +
        ",'" + zipCode + '\'' +
        ",'" + country + '\'' +
        ",'" + website + '\'' +
        ')';
  }
}
