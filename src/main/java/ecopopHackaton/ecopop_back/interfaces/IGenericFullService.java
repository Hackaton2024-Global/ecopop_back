package ecopopHackaton.ecopop_back.interfaces;

import java.util.List;

public interface IGenericFullService <T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
}
