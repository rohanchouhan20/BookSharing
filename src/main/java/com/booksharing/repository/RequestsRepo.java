package com.booksharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.Requests;
import com.booksharing.entity.User;

//@Component
@Repository
public interface RequestsRepo extends CrudRepository<Requests, Integer> {
	@Query(value = "select * from requests where reciever=:id and accepted=:accept or (reciever=:id and follow_back=:follow)", nativeQuery = true)
	public List<Requests> findByUserIdAndAccept(@Param("id") int id, @Param("accept") boolean accept,
			@Param("follow") boolean follow);

	@Modifying
	@Query(value = "update requests set accepted=:a where reciever=:acceptUser and sender=:userId", nativeQuery = true)
	public int updateAcceptRequest(@Param("a") boolean accepted, @Param("acceptUser") int acceptUser,
			@Param("userId") int userId);

	@Query(value = "select * from requests where sender=:id and reciever=:acceptUser ", nativeQuery = true)
	public Requests findByUserIdAndAcceptAndSendUser(@Param("id") int id, @Param("acceptUser") int acceptUser);

	@Modifying
	@Query(value = "delete from requests where reciever=:acceptUser and sender=:userId", nativeQuery = true)
	public int deleteByUserIdAndFollowerId(@Param("acceptUser") int acceptUser, @Param("userId") int userId);

	@Query(value = "select r from Requests r where r.reciever=:acceptUser and r.sender=:userEntity")
	public Requests findByUserIdAndfollower(@Param("acceptUser") int acceptUser, @Param("userEntity") User user);
}
