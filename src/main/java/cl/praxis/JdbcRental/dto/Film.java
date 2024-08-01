package cl.praxis.JdbcRental.dto;

public class Film {
  private int filmId;
  private String title;
  private String description;
  private int releaseYear;
  private int languageId;
  private float rentalDuration;
  private int rentalRate;
  private int length;
  private float replacementCost;
  private String rating;
  private String specialFeatures;

  public Film() {
  }

  public Film(int filmId, String title, String description, int releaseYear, int languageId, float rentalDuration, int rentalRate, int length, float replacementCost, String rating, String specialFeatures) {
    this.filmId = filmId;
    this.title = title;
    this.description = description;
    this.releaseYear = releaseYear;
    this.languageId = languageId;
    this.rentalDuration = rentalDuration;
    this.rentalRate = rentalRate;
    this.length = length;
    this.replacementCost = replacementCost;
    this.rating = rating;
    this.specialFeatures = specialFeatures;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getLanguageId() {
    return languageId;
  }

  public void setLanguageId(int languageId) {
    this.languageId = languageId;
  }

  public float getRentalDuration() {
    return rentalDuration;
  }

  public void setRentalDuration(float rentalDuration) {
    this.rentalDuration = rentalDuration;
  }

  public int getRentalRate() {
    return rentalRate;
  }

  public void setRentalRate(int rentalRate) {
    this.rentalRate = rentalRate;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public float getReplacementCost() {
    return replacementCost;
  }

  public void setReplacementCost(float replacementCost) {
    this.replacementCost = replacementCost;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getSpecialFeatures() {
    return specialFeatures;
  }

  public void setSpecialFeatures(String specialFeatures) {
    this.specialFeatures = specialFeatures;
  }

  @Override
  public String toString() {
    return "Film{" +
            "filmId=" + filmId +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", releaseYear=" + releaseYear +
            ", languageId=" + languageId +
            ", rentalDuration=" + rentalDuration +
            ", rentalRate=" + rentalRate +
            ", length=" + length +
            ", replacementCost=" + replacementCost +
            ", rating='" + rating + '\'' +
            ", specialFeatures='" + specialFeatures + '\'' +
            '}';
  }
}
