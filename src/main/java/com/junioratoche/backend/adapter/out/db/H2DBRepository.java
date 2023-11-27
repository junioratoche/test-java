package com.junioratoche.backend.adapter.out.db;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.junioratoche.backend.adapter.out.db.entity.PriceEntity;
import com.junioratoche.backend.adapter.out.db.mapper.PriceEntityMapper;
import com.junioratoche.backend.domain.Price;
import com.junioratoche.backend.domain.exceptions.DataNotFoundException;
import com.junioratoche.backend.port.out.db.EntityRepositoryOutputPort;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class H2DBRepository implements EntityRepositoryOutputPort {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	PriceEntityMapper priceEntityMapper;

	@Override
	public List<Price> getAll() {
		TypedQuery<PriceEntity> query = entityManager.createQuery("SELECT p FROM PriceEntity p", PriceEntity.class);
		List<PriceEntity> priceEntityList = query.getResultList();
		return priceEntityList.stream().map(priceEntityMapper::priceEntityToPrice).collect(Collectors.toList());
	}

	@Override
	public Price getPriceByBrandAndProductInApplicationDate(LocalDateTime applicationDate, int productId, int brandId) {
		TypedQuery<PriceEntity> query = entityManager.createQuery(
				"SELECT p FROM PriceEntity p " + "WHERE :applicationDate BETWEEN p.startDate AND p.endDate "
						+ "AND p.productId = :productId AND p.brand.id = :brandId " + "ORDER BY p.priority DESC",
				PriceEntity.class);

		query.setParameter("applicationDate", applicationDate);
		query.setParameter("productId", productId);
		query.setParameter("brandId", brandId);
		query.setMaxResults(1);

		try {
            PriceEntity result = query.getSingleResult();
            return priceEntityMapper.priceEntityToPrice(result);
        } catch (NoResultException e) {
            throw new DataNotFoundException("No data found for the provided parameters.");
        }
	}

}