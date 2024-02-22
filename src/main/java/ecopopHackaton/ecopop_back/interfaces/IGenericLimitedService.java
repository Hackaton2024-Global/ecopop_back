package ecopopHackaton.ecopop_back.interfaces;

import java.util.List;

public interface IGenericLimitedService <T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
}
