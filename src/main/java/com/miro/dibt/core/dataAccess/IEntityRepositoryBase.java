package com.miro.dibt.core.dataAccess;

import javax.persistence.Entity;
import java.util.List;

public interface IEntityRepositoryBase<T extends IEntity> {
    List<T> getAll();
    void add(T t);
    void update(T t);
    void delete (T t);
}
