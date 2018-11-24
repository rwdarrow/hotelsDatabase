/**
 * Name: Hotel.java
 * Author: Robert Darrow
 * Description: Class describing a hotel object.
 */

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

  /**
   * Default Constructor.
   * @param name the hotel name
   * @param stars the hotel stars
   * @param address the hotel address
   * @param city the hotel city
   * @param state the hotel state
   * @param zipCode the hotel zip code
   * @param country the hotel country
   * @param website the hotel website
   */
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

  /**
   * Returns the hotel name.
   * @return name the hotel name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the hotel name.
   * @param name the hotel name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the hotel number of stars.
   * @return stars the hotel stars
   */
  public double getStars() {
    return stars;
  }

  /**
   * Sets the hotel number of stars.
   * @param stars the hotel stars
   */
  public void setStars(double stars) {
    this.stars = stars;
  }

  /**
   * Returns the hotel address.
   * @return address the hotel address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the hotel address.
   * @param address the hotel address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Returns the hotel city.
   * @return city the hotel city
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets the hotel city.
   * @param city the hotel city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Returns the hotel zip code.
   * @return zipCode the hotel zip code
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Sets the hotel zip code.
   * @param zipCode the hotel zipCode
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * Returns the hotel state.
   * @return state the hotel state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets the hotel state.
   * @param state the hotel state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Returns the hotel country.
   * @return country the hotel country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets the hotel country.
   * @param country the hotel country
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Returns the hotel website.
   * @return website the hotel website
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Sets the hotel website.
   * @param website the hotel website
   */
  public void setWebsite(String website) {
    this.website = website;
  }

  @Override
  public String toString() {
    return "Hotel{"
        + "name='" + name + '\''
        + ", stars=" + stars
        + ", address='" + address + '\''
        + ", city='" + city + '\''
        + ", zipCode='" + zipCode + '\''
        + ", state='" + state + '\''
        + ", country='" + country + '\''
        + ", website='" + website + '\''
        + '}';
  }

  /**
   * Returns a formatted string that a SQL query can use.
   * @return String the formatted string to pass to a sql query
   */
  public String toDatabaseQueryString() {
    return
        "('" + name + '\''
        + "," + stars
        + ",'" + address + '\''
        + ",'" + city + '\''
        + ",'" + state + '\''
        + ",'" + zipCode + '\''
        + ",'" + country + '\''
        + ",'" + website + '\''
        + ')';
  }
}
