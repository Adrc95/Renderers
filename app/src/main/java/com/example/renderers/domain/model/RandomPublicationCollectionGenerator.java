
package com.example.renderers.domain.model;


import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class RandomPublicationCollectionGenerator {

  private static final Map<String, String> VIDEO_INFO = new HashMap<String, String>();

  private Random random;

  public RandomPublicationCollectionGenerator() {
    this.random = new Random();
    initializePublicationInfo();
  }

  public AdapteeCollection<Publication> generateListAdapteePublicationCollection(int count) {
    List<Publication> publications = new LinkedList<>();
    for (int i = 0; i < count; i++) {
      boolean isProduct = random.nextBoolean();
      Publication publication = generateRandomPublication(isProduct);
      publications.add(publication);
    }
    return new ListAdapteeCollection<>(publications);
  }

  public List<Publication> generateListPublication(int count) {
    List<Publication> publications = new LinkedList<>();
    for (int i = 0; i < count; i++) {
      boolean isProduct = random.nextBoolean();
      Publication publication = generateRandomPublication(isProduct);
      publications.add(publication);
    }
    return publications;
  }


  private void initializePublicationInfo() {
    VIDEO_INFO.put("The Big Bang Theory", "http://thetvdb.com/banners/_cache/posters/80379-9.jpg");
    VIDEO_INFO.put("Breaking Bad", "http://thetvdb.com/banners/_cache/posters/81189-22.jpg");
    VIDEO_INFO.put("Arrow", "http://thetvdb.com/banners/_cache/posters/257655-15.jpg");
    VIDEO_INFO.put("Game of Thrones", "http://thetvdb.com/banners/_cache/posters/121361-26.jpg");
    VIDEO_INFO.put("Lost", "http://thetvdb.com/banners/_cache/posters/73739-2.jpg");
    VIDEO_INFO.put("How I met your mother",
        "http://thetvdb.com/banners/_cache/posters/75760-29.jpg");
    VIDEO_INFO.put("Dexter", "http://thetvdb.com/banners/_cache/posters/79349-24.jpg");
    VIDEO_INFO.put("Sleepy Hollow", "http://thetvdb.com/banners/_cache/posters/269578-5.jpg");
    VIDEO_INFO.put("The Vampire Diaries", "http://thetvdb.com/banners/_cache/posters/95491-27.jpg");
    VIDEO_INFO.put("Friends", "http://thetvdb.com/banners/_cache/posters/79168-4.jpg");
    VIDEO_INFO.put("New Girl", "http://thetvdb.com/banners/_cache/posters/248682-9.jpg");
    VIDEO_INFO.put("The Mentalist", "http://thetvdb.com/banners/_cache/posters/82459-1.jpg");
    VIDEO_INFO.put("Sons of Anarchy", "http://thetvdb.com/banners/_cache/posters/82696-1.jpg");
  }


  private Publication generateRandomPublication(boolean isProduct) {
    int id = randomId();
    int temp = configureTitleAndThumbnail();
    String title = getKeyForIndex(temp);
    String thumbnail = getValueForIndex(temp);

    if(isProduct){
      boolean like = configureLikeStatus();
      boolean prominent = configureProminent();
      int price = randomPrice();
      return new Product(randomId(), thumbnail, title, String.format("%s €", price), like, prominent);
    }

    return new Ad(randomId(), thumbnail, title, "Empresa", configureHeader());
  }

  private boolean configureHeader(){
    return random.nextBoolean();
  }

  private int randomId(){
    return random.nextInt(Integer.MAX_VALUE);
  }

  private int randomPrice(){
    return random.nextInt(999) + 1;
  }

  private boolean configureLikeStatus() {
    return random.nextBoolean();
  }

  private boolean configureProminent() {
    return random.nextBoolean();
  }

  private int configureTitleAndThumbnail() {
    int maxInt = VIDEO_INFO.size();
    return random.nextInt(maxInt);
  }

  private String getKeyForIndex(int randomIndex) {
    int i = 0;
    for (String index : VIDEO_INFO.keySet()) {
      if (i == randomIndex) {
        return index;
      }
      i++;
    }
    return null;
  }

  private String getValueForIndex(int randomIndex) {
    int i = 0;
    for (String index : VIDEO_INFO.keySet()) {
      if (i == randomIndex) {
        return VIDEO_INFO.get(index);
      }
      i++;
    }
    return "";
  }
}
