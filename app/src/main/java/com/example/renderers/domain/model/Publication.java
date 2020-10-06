package com.example.renderers.domain.model;


public class Publication {

  private int id;
  private String photo;
  private String title;

  public Publication(){

  }

  public Publication(int id, String photo, String title) {
    this.id = id;
    this.photo = photo;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public String getPhoto() {
    return photo;
  }

  public String getTitle() {
    return title;
  }

  @Override public boolean equals(Object obj) {
    if (obj instanceof Publication) {
      Publication other = (Publication) obj;
      return title.equals(other.title)
              && photo.equals(other.photo)
              && id == other.id;
    } else {
      return false;
    }
  }

  /*
   * In this example we use the thumbnail property as hashCode because we assume every thumbnail is
   * going to be different for every video. It can be used as an identifier. This is needed to
   * support differential updates properly. You can use your item ID if you have one.
   */
  @Override
  public int hashCode() {
    return id;
  }
}
