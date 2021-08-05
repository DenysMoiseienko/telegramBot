package telegramBot.telegramBot.cache;

import java.util.List;

public interface Cache<T> {
    
    void add(T t);
    void remove(T t);
    T findById(Long id);
    List<T> getAll();
}
