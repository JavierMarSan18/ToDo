package edu.jjms.persistence.repositories.impl;

import edu.jjms.mappers.inter.ITaskMapper;
import edu.jjms.models.entities.Task;
import edu.jjms.persistence.repositories.inter.ITaskRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements ITaskRepository {

    private final EntityManager entityManager;

    public TaskRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        String jpql = "SELECT t FROM Task t";
        try{
            entityManager.getTransaction().begin();
            tasks = entityManager.createQuery(jpql, Task.class).getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<Task> findAllTaskByState(boolean isCompleted) {
        List<Task> tasks = new ArrayList<>();
        try{
            String jpql = "SELECT t FROM Task t WHERE t.isCompleted =: isCompleted";
            TypedQuery<Task> query = entityManager.createQuery(jpql, Task.class);
            query.setParameter("isCompleted", isCompleted);

            entityManager.getTransaction().begin();
            tasks = query.getResultList();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void create(Task task) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Task task) {
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Task> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Task.class);
            Root<Task> root = criteriaUpdate.from(Task.class);

            criteriaUpdate.set(root.get("description"), task.getDescription());
            criteriaUpdate.set(root.get("startDate"), task.getStartDate());
            criteriaUpdate.set(root.get("endDate"), task.getStartDate());
            criteriaUpdate.set(root.get("isCompleted"), task.getIsCompleted());
            criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), task.getId()));

            entityManager.getTransaction().begin();
            entityManager.createQuery(criteriaUpdate).executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Task task) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Task> criteriaDelete = criteriaBuilder.createCriteriaDelete(Task.class);

            Root<Task> root = criteriaDelete.from(Task.class);
            criteriaDelete.where(criteriaBuilder.equal(root.get("id"), task.getId()));

            entityManager.getTransaction().begin();
            entityManager.createQuery(criteriaDelete).executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
