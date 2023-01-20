package eu.horyzont.neighbourssocializer.domain;

public interface EventRepository {

  String insert(Event event);

  void update(String id, Event event);

  void deleteById(String id);


}
