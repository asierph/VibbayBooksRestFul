package REST;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import POJOS.Articulo;
import POJOS.Usuario;

public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();

    public String create(T entity) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            em.refresh(entity);
            return "ok";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public String edit(T entity) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return "ok";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    /**
     * Metodo con el que se buscara un usuario mediante su correo y contraseña
     * 
     */
    public T findByEmailPass(String pEmail, String pPass) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Usuario.findByEmailPass", Usuario.class);
        query.setParameter("email", pEmail);
        query.setParameter("password", pPass);
        return (T) query.getSingleResult();
    }
    
    public List<T> findAllByIdArticulo(Integer id){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Articulo.findByIdarticulo", Articulo.class);
        query.setParameter("idarticulo", id);
        return query.getResultList();
    }
    
    public List<T> findAllArticuloByIdUsuario(Integer idUsuario){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Articulo.findAllByIdvendedor", Articulo.class);
        query.setParameter("idvendedor", idUsuario);
        return query.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }   
}
