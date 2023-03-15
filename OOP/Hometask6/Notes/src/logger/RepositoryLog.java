package logger;

import model.Repository;

import java.util.List;
import java.util.logging.Logger;

public class RepositoryLog<T> extends LogImpl implements Repository<T> {
    Repository<T> repository;
    public RepositoryLog(Repository<T> repository){
        this.repository = repository;
        this.logger = Logger.getLogger(repository.getClass().getName());
        setParams();
    }

    @Override
    public T find(T item) {
        return repository.find(item);
    }

    @Override
    public String create(T item) {
        String id = repository.create(item);
        log("Создан новый объект класса "+item.getClass().getName()+" с id="+id);
        return id;
    }

    @Override
    public List<T> readAll() {
        List<T> data = repository.readAll();
        log("Получено объектов "+data.size());
        return data;
    }

    @Override
    public String update(T item) {
        String id = repository.update(item);
        log("Обновлен объект класса "+item.getClass().getName()+" с id="+id);
        return id;
    }

    @Override
    public String delete(T item) {
        String id = repository.delete(item);
        log("Удален объект класса "+item.getClass().getName()+" с id="+id);
        return id;
    }

    @Override
    public int idIncrement() {
        return repository.idIncrement();
    }
}
